CREATE DATABASE devsu;

\c devsu;

CREATE TABLE Clients (
    clientId SERIAL PRIMARY KEY,
    password VARCHAR(4),
    status BOOLEAN,
    name VARCHAR(255),
    gender VARCHAR(10),
    age INTEGER,
    identification VARCHAR(20) UNIQUE,
    address VARCHAR(50),
    phone VARCHAR(20)
);

CREATE TABLE Accounts (
    accountId SERIAL PRIMARY KEY,
    accountNumber VARCHAR(12),
    accountType VARCHAR(10),
    initialBalance NUMERIC,
    status BOOLEAN,
    clientId BIGINT,
    FOREIGN KEY (clientId) REFERENCES Clients(clientId)
);

CREATE TABLE Movements (
    movementId SERIAL PRIMARY KEY,
    date TIMESTAMP,
    type VARCHAR(10),
    amount NUMERIC,
    balance NUMERIC,
    accountId BIGINT,
    FOREIGN KEY (accountId) REFERENCES Accounts(accountId)
);

CREATE SEQUENCE clients_seq START 1;
CREATE SEQUENCE accounts_seq START 1;
CREATE SEQUENCE movements_seq START 1;

CREATE INDEX idx_movements_accountid_date ON Movements (accountid, date);

CREATE INDEX idx_clients_identification ON Clients (identification);

CREATE INDEX idx_accounts_accountid ON Accounts (accountId);
