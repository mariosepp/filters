USE db_filters;
GO

-- Add users for application and liquibase
IF NOT EXISTS (SELECT name FROM sys.sysusers WHERE name = N'usr_filters')
BEGIN
    CREATE LOGIN [usr_filters] WITH PASSWORD = 'KYPr1zn3yqO5FkKV';
    CREATE LOGIN [usr_filters_liquibase] WITH PASSWORD = 'VJXiTP1VOkEdXleW';

    CREATE USER [usr_filters] FOR LOGIN [usr_filters];
    CREATE USER [usr_filters_liquibase] FOR LOGIN [usr_filters_liquibase];

    -- Grant permissions for usr_filters
    ALTER ROLE db_datareader ADD MEMBER [usr_filters];
    ALTER ROLE db_datawriter ADD MEMBER [usr_filters];

    -- Grant permissions for usr_filters_liquibase
    ALTER ROLE db_datareader ADD MEMBER [usr_filters_liquibase];
    ALTER ROLE db_datawriter ADD MEMBER [usr_filters_liquibase];
    ALTER ROLE db_ddladmin ADD MEMBER [usr_filters_liquibase];
END
GO
