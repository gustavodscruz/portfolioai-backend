-- ...existing code...
CREATE TABLE app_user (
                      id BIGSERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      linkedin_profile VARCHAR(255),
                      github_profile VARCHAR(255)
);
-- ...existing code...