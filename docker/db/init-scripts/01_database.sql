USE master;
GO

IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'db_filters')
BEGIN
    -- Create a new database
    CREATE DATABASE db_filters;
END
GO
