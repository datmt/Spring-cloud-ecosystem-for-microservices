#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER spring_cloud PASSWORD 'spring_cloud';
	CREATE DATABASE billing_service;
	CREATE DATABASE delivery_service;
	CREATE DATABASE inventory_service;
	GRANT ALL PRIVILEGES ON DATABASE  billing_service TO spring_cloud;
	GRANT ALL PRIVILEGES ON DATABASE  delivery_service TO spring_cloud;
	GRANT ALL PRIVILEGES ON DATABASE  inventory_service TO spring_cloud;
EOSQL