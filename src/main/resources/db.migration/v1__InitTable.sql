CREATE DATABASE todo_item;
USE todo_item;

CREATE TABLE item (
   id BIGINT NOT NULL auto_increment primary key,
   timestamp TIMESTAMP NOT NULL DEFAULT now(),
   text VARCHAR(128) NOT NULL,
   done Boolean NOT NULL DEFAULT FALSE
);

INSERT INTO item (text, done) VALUES ('this is first default item', true);
INSERT INTO item (text) VALUES ('this is second default item');
