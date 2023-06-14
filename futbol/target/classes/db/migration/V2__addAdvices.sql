CREATE TABLE IF NOT EXISTS advices(
	id SERIAL,
	player_id INT NOT NULL,
	date_match VARCHAR (20) NOT NULL,
	team_match VARCHAR (100) NOT NULL,
	color_card VARCHAR (100) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (player_id) REFERENCES player(id)
);