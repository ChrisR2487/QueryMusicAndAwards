
DROP TABLE musicTitles;
DROP TABLE musicAwards;

create table musicTitles(
	musicID int not null,
	genre varchar(100) not null,
    artist varchar(100) not null,
    title varchar(150) not null,
    album varchar(100) not null,
    releaseDate int not null,
    primary key (musicID)
);

create table musicAwards(
	musicID int not null,
    award varchar(100) not null,
    awardYear int not null,
    foreign key (musicID) references musicTitles (musicID)
);

insert into musicTitles(musicID, genre, artist, title, album, releaseDate)
values
(1,'Jazz', 'Joao Gilberto', 'S Wonderful', 'Amoroso', 1977),
(2,'Jazz', 'Joao Gilberto', 'Chega De Saudade', 'Latin Legends', 1959),
(3,'Hip-Hop', 'Drake', 'Toosie Slide', 'Toosie Slide', 2020),
(4,'R&B', 'Doja Cat', 'Say so', 'Hot Pink', 2019),
(5,'Pop', 'Dua Lipa', 'Dont\'t Start Now', 'Don\'t Start Now', 2019),
(6,'R&B', 'Bruno Mars', 'That\'s What I Like', '24K Magic', 2016),
(7,'R&B', 'Beyonce', 'Single Ladies', 'If I Were A Boy', 2008),
(8,'Alternative', 'Billie ELilsh', 'Bad Guy', 'When We All Fall Asleep, Where Do We Go?', 2019),
(9,'Classical', 'Michael Tilson Thomas', 'Mahler: Symphony No. 8; Adagio From Symphony No. 10', 'N/A', 2009),
(10,'Classical', 'Pierre Boulez', 'Debussy: La Mer; Nocturnes; Jeux', 'N/A', 2009);

insert into musicAwards (musicID, award, awardYear)
values
(6, 'Song of the Year', 2018),
(7, 'Best R&B Song', 2009),
(8, 'Song of the Year', 2020),
(9, 'Best Classical Album', 2009),
(10, 'Best Classical Album', 1995);






