/*Movies Table Details*/
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2017-03-15', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2019-12-23', 'Superhero', '0');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2020-08-21', 'Romance', '0');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2021-07-02', 'Science Fiction', '1');
INSERT INTO `moviecruiser`.`movies` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers: End Game', '2750760348', '1', '2022-11-02', 'Superhero', '1');

/*User Table Details*/
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Ajay');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Shiva');

/*Favorites Table Details*/
INSERT INTO `moviecruiser`.`favorites` (`ft_us_id`, `ft_mo_id`) VALUES ('1', '1');
INSERT INTO `moviecruiser`.`favorites` (`ft_us_id`, `ft_mo_id`) VALUES ('1', '3');
INSERT INTO `moviecruiser`.`favorites` (`ft_us_id`, `ft_mo_id`) VALUES ('1', '5');

-- View Movie List Admin (TYUC001)
SELECT * FROM moviecruiser.movies;

-- View Movie List Customer (TYUC002)
SELECT * FROM moviecruiser.movies where mo_active='1' and mo_date_of_launch > (select CURDATE());

-- Edit Movie (TYUC003)
SELECT * FROM moviecruiser.movies where mo_id=1;

UPDATE moviecruiser.movies set mo_title='fff', mo_gross=3101258951, mo_active='1', mo_date_of_launch='2020-01-15', mo_genre='Romance', mo_has_teaser='1' where mo_id=1;

-- Add to Favorites (TYUC004)
INSERT INTO `moviecruiser`.`favorites` (`ft_us_id`, `ft_mo_id`) VALUES ('1', '1');
INSERT INTO `moviecruiser`.`favorites` (`ft_us_id`, `ft_mo_id`) VALUES ('1', '3');
INSERT INTO `moviecruiser`.`favorites` (`ft_us_id`, `ft_mo_id`) VALUES ('1', '5');

-- View Favorites (TYUC005)
select mo_title,mo_gross,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from moviecruiser.movies
inner join moviecruiser.favorites on ft_mo_id=mo_id where ft_us_id=1;

select count(*) as Num_of_Favorites from moviecruiser.movies inner join moviecruiser.favorites on ft_mo_id=mo_id;

-- Remove Movie from Favorites (TYUC006) 
delete favorites from favorites where ft_us_id=1 and ft_mo_id=3 limit 1;