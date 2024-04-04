CREATE TABLE Employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    email VARCHAR(255),
    phoneNumber VARCHAR(20),
    department VARCHAR(255),
    created_At BIGINT,
    update_At BIGINT,
    deleted_At BIGINT
);
