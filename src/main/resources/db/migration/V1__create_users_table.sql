CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    born_date DATE,
    gender VARCHAR(10),
    user_status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_date TIMESTAMP NOT NULL DEFAULT NOW(),
    last_modified_date TIMESTAMP NOT NULL DEFAULT NOW(),
    created_by VARCHAR(100),
    last_modified_by VARCHAR(100)
);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_status ON users(user_status);