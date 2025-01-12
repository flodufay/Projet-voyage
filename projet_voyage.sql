-- -------------------------------
-- Structure de la table `client`
-- -------------------------------

CREATE TABLE IF NOT EXISTS `client` (
	`id_client` int(11) NOT NULL auto_increment,
	`nom` varchar(25) NOT NULL,
	`prenom` varchar(25) NOT NULL,
	`num_telephone` int(10) default NULL,
	`mail` varchar(60) default NULL,
	`date_naissance` DATE,
	PRIMARY KEY (`id_client`)
);

-- -------------------------------
-- Contenu de la table `client`
-- -------------------------------

INSERT INTO `client` (`nom`, `prenom`, `num_telephone`, `mail`, `date_naissance`) VALUES('HEURTEL', 'Olivier', 0687731346, 'o.heurtel@gmail.com', '1985-07-22'),
('THIBAUD', 'Cyril', 0203040506, NULL, '2000-04-10'),
('GUERIN', 'Brice-Arnaud', 0304050607, 'barnaud.guerin@outlook.com', '1967-10-30');

-- -------------------------------
-- Structure de la table `vol`
-- -------------------------------

CREATE TABLE IF NOT EXISTS `vol` (
	`num_vol` varchar(25) NOT NULL,
	`id_compagnie` int(11) NOT NULL,
	`date_heure_depart` DATETIME NOT NULL,
	`lieu_depart` varchar(25) NOT NULL,
	`date_heure_arrivee` DATETIME NOT NULL,
	`lieu_arrivee` varchar(25) NOT NULL,
	PRIMARY KEY (`num_vol`),
	UNIQUE KEY `id_compagnie` (`id_compagnie`)
);

-- -------------------------------
-- Contenu de la table `vol`
-- -------------------------------

INSERT INTO `vol` (`num_vol`, `id_compagnie`, `date_heure_depart`, `lieu_depart`, `date_heure_arrivee`, `lieu_arrivee`) VALUES
('JFX204', '1', '2024-12-27 16:52', 'VIENNA', '2024-12-27 21:03', 'MADRID'),
('GSX130', '2', '2024-08-10 10:02', 'PARIS', '2024-08-10 11:03', 'LONDON');

-- -------------------------------
-- Structure de la table `compagnie`
-- -------------------------------

CREATE TABLE IF NOT EXISTS `compagnie` (
	`id_compagnie` int(11) NOT NULL auto_increment,
	`nom_compagnie` varchar(25) NOT NULL,
	PRIMARY KEY (`id_compagnie`)
);

-- -------------------------------
-- Contenu de la table `compagnie`
-- -------------------------------

INSERT INTO `compagnie` (`nom_compagnie`) VALUES
('EASYJET'),
('RYANAIR');

-- -------------------------------
-- Structure de la table `reservation`
-- -------------------------------

CREATE TABLE IF NOT EXISTS `reservation` (
	`id_reservation` int(11) NOT NULL auto_increment,
	`id_client` int(11) NOT NULL,
	`id_reservataire` int(11) NOT NULL,
	`id_conseiller` int(11) NOT NULL,
	`num_vol` varchar(25) NOT NULL,
	`type_vol` varchar(25) NOT NULL,
	`type_paiement` varchar(2) NOT NULL,
	`date_paiement` DATE,
	`annulation_possible` TINYINT(1),
	PRIMARY KEY (`id_reservation`)
);

-- -------------------------------
-- Contenu de la table `reservation`
-- -------------------------------

INSERT INTO `reservation` (`id_client`, `id_reservataire`, `id_conseiller`, `num_vol`, `type_vol`, `type_paiement`, `date_paiement`, `annulation_possible`) VALUES 
(1, 1, 1, 'JFX204', 'Business', 'CB', '2024-06-27', '1'),
(2, 1, 1, 'JFX204', 'Business', 'CB', '2024-06-27', '1'),
(3, 3, 2, 'GSX130', 'Economy', 'CB', '2024-07-03', '0');

