CREATE TABLE user_profiles (
    user_id UUID PRIMARY KEY NOT NULL,
    display_name VARCHAR(255),
    phone_number VARCHAR(15),
    bio VARCHAR(1000),
    location VARCHAR(255),
    profile_image_url VARCHAR(1024),
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);