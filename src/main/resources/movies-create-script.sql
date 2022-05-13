# 1. go get the json file from glitch
# 2. copypasta into a new json file under /resources

# --> You may need to establish a connection to your localhost db here

# 3. create the movies_db
create database if not exists movies_db;

# 4. use the movies_db
use movies_db;

# 5. drop the table(s) to which no other tables are dependent (none at first)
drop table if exists movies;
drop table if exists directors;

# 6. map the json movie properties to movies table columns
# --> start with just a movies table with all the columns found in the movie json properties
create table if not exists directors
(
id int unsigned not null auto_increment primary key,
name varchar(120)
);

create table if not exists movies
(
    id       int unsigned not null auto_increment primary key,
    title    varchar(120),
    rating   char(1),
    year     char(4),
    poster   text,
    plot     text,
    director_id int unsigned not null,
    foreign key (director_id) references directors(id)
);

# 6a. Run the script to make sure it works
describe movies;
describe directors;

# 7. refactor to extract the directors to a new table with just an id and name
# --> change the movies table to reference the directors table via Foreign Key
# --> now that movies is dependent on directors, you need to move directors above movies in the script

# 8. Go add DROP IF EXIST statements for movies and directors

# 9. RUN IT!

create table if not exists genres
(
    id int unsigned not null auto_increment primary key,
    name varchar(255)
);

describe genres;

create table if not exists movie_genre
(
    movie_id int unsigned not null,
    genre_id int unsigned not null,
    foreign key (movie_id) references movies(id),
    foreign key (genre_id) references genres(id)
);

describe movie_genre;

create table if not exists actors
(
    id int unsigned not null auto_increment primary key,
    name varchar(255)
);

describe actors;

create table if not exists movie_actor
(
    movie_id int unsigned not null,
    actor_id int unsigned not null,
    foreign key (movie_id) references movies(id),
    foreign key (actor_id) references actors(id)
);

describe movie_actor;



# create a genres table with two columns: id and name

# create a many-to-many relationship b/t movies and genres by creating a movie_genre table.
# --> It needs to only contain a movie_id and genre_id (be sure to foreign key those to their respective tables)

# create create an actors table with two columns: id and name

# create a many-to-many relationship b/t movies and actors by creating movie_actor table.
# --> It needs to only contain a movie_id and actor_id (be sure to foreign key those to their respective tables)





# CREATE DATABASE IF NOT EXISTS movies_db;
#
# USE movies_db;
#
# CREATE TABLE IF NOT EXISTS movies
# (
#     id    INT UNSIGNED NOT NULL AUTO_INCREMENT,
#     title VARCHAR(255) NOT NULL,
#     year  CHAR(4)      NOT NULL,
#     plot  TEXT,
#     PRIMARY KEY (id)
# );

insert into movies(title, rating, year, poster, plot, director_id)
values ('Java the Movie', "5", "1982", "as;ldkfd;lfkjjjjddghhgsaljk", "millions of elite space warrior instances take over the galaxy.", 1);

select * from movies;


insert into genres(name)
values ('Thriller'),
       ('Horror'),
       ('Romance'),
       ('Drama'),
       ('Comedy'),
       ('SciFi');

describe genres;

select * from genres;


insert into movie_genre(genre_id, movie_id)
values (1, 6),
       (2,6),
       (3, 6);

describe movie_genre;

select * from movie_genre;


insert into actors(name)
values ('Thomas Saenz'),
       ('Christopher Zavala'),
       ('Damon McGowan');

describe actors;

select * from actors;

insert into movie_actor(actor_id, movie_id)
values (1, 6),
       (2, 6),
       (3, 6);

describe movie_actor;

select * from movie_actor;


insert into directors(name)
values ('Jack Jackie'),
       ('Bobby Bob'),
       ('Damon McGowan');

describe directors;

select * from directors;


