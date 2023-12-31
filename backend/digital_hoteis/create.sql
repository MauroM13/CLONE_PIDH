DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS attraction;
DROP TABLE IF EXISTS guest;
DROP TABLE IF EXISTS host;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS room;

CREATE TABLE category (
    id BINARY(16) PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    image_url VARCHAR(255),
    ratings ENUM('ONE_STAR', 'TWO_STARS', 'THREE_STARS', 'FOUR_STARS', 'FIVE_STARS')
);

CREATE TABLE address (
    id BINARY(16) PRIMARY KEY,
    street VARCHAR(100),
    district VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(100),
    zipcode CHAR(10),
    country VARCHAR(60),
    created_At DATETIME,
    updated_At DATETIME
);

CREATE TABLE contact (
    id BINARY(16) PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20),
    created_At DATETIME,
    updated_At DATETIME
);

CREATE TABLE attraction (
    id BINARY(16) PRIMARY KEY,
    address_id BINARY(16),
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY (address_id) REFERENCES address(id)
);



CREATE TABLE guest (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    birthdate DATE,
    gender CHAR(1) NOT NULL,
    created_At DATETIME,
    updated_At DATETIME,
    address_id BINARY(16),
    contact_id BINARY(16),
    FOREIGN KEY (address_id) REFERENCES address(id),
    FOREIGN KEY (contact_id) REFERENCES contact(id)
--    CONSTRAINT fk_guest_contact_id FOREIGN KEY (id) REFERENCES guest(id)
--    CONSTRAINT fk_guest_address_id FOREIGN KEY (id) REFERENCES address(id)
);

CREATE TABLE host (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(35) NOT NULL,
    surname VARCHAR(65) NOT NULL
);

CREATE TABLE hotel (
    id BINARY(16) PRIMARY KEY,
    fk_hotel_category_id BINARY(16),
    fk_hotel_address_id BINARY(16),
    fk_hotel_contact_id BINARY(16),
    trading_name VARCHAR(65) NOT NULL,
    cnpj VARCHAR(20) NOT NULL,
    created_At DATETIME,
    updated_At DATETIME,
    description TEXT NOT NULL,
    FOREIGN KEY (fk_hotel_category_id) REFERENCES category(id),
    FOREIGN KEY (fk_hotel_address_id) REFERENCES address(id),
    FOREIGN KEY (fk_hotel_contact_id) REFERENCES contact(id)
);

CREATE TABLE reservation (
    id BINARY(16) PRIMARY KEY,
    check_in_date DATE,
    check_out_date DATE,
    requests TEXT NOT NULL,
    is_canceled BOOLEAN,
    created_At DATETIME,
    updated_At DATETIME,
    guest_id BINARY(16),
    FOREIGN KEY (guest_id) REFERENCES guest(id)
);

CREATE TABLE room (
    id BINARY(16) PRIMARY KEY,
    hotel_id BINARY(16) NOT NULL,
    description VARCHAR(255) NOT NULL,
    max_number_of_guests INTEGER,
    has_private_bathroom BOOLEAN,
    has_bathtub BOOLEAN,
    has_kitchen BOOLEAN,
    has_stove BOOLEAN,
    has_microwave BOOLEAN,
    are_pets_allowed BOOLEAN,
    price DECIMAL(10, 2),
    FOREIGN KEY (hotel_id) REFERENCES hotel(id)
);
