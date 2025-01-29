CREATE TABLE profile (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    headline VARCHAR(255),
    about TEXT,
    experiences TEXT[],
    skills TEXT[],
    education TEXT[],
    FOREIGN KEY (user_id) REFERENCES app_user(id) ON DELETE CASCADE
);

CREATE TABLE project (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    name VARCHAR(255),
    description TEXT,
    repo_url VARCHAR(255),
    live_demo_url VARCHAR(255),
    technologies TEXT[],
    FOREIGN KEY (user_id) REFERENCES app_user(id) ON DELETE CASCADE
);
