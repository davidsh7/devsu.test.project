@echo off

set PGPASSWORD=postgres
set PGOPTIONS=--client-min-messages=warning

psql -U postgres -d postgres -h localhost -f init-script.sql