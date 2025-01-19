-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : sam. 18 jan. 2025 à 17:23
-- Version du serveur : 11.6.2-MariaDB-ubu2404
-- Version de PHP : 8.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_voyage`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `num_telephone` varchar(10) DEFAULT NULL,
  `mail` varchar(60) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `nom`, `prenom`, `num_telephone`, `mail`, `date_naissance`) VALUES
(1, 'HEURTEL', 'Olivier', '0687731346', 'o.heurtel@gmail.com', '1985-07-22'),
(2, 'THIBAUD', 'Cyril', '0203040506', NULL, '2000-04-10'),
(3, 'GUERIN', 'Brice-Arnaud', '0304050607', 'barnaud.guerin@outlook.com', '1967-10-30');

-- --------------------------------------------------------

--
-- Structure de la table `compagnie`
--

CREATE TABLE `compagnie` (
  `id_compagnie` int(11) NOT NULL,
  `nom_compagnie` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Déchargement des données de la table `compagnie`
--

INSERT INTO `compagnie` (`id_compagnie`, `nom_compagnie`) VALUES
(1, 'EASYJET'),
(2, 'RYANAIR');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_reservataire` int(11) NOT NULL,
  `id_conseiller` int(11) NOT NULL,
  `num_vol` int(11) NOT NULL,
  `type_vol` varchar(25) NOT NULL,
  `type_paiement` varchar(2) NOT NULL,
  `date_paiement` date DEFAULT NULL,
  `annulation_possible` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `id_client`, `id_reservataire`, `id_conseiller`, `num_vol`, `type_vol`, `type_paiement`, `date_paiement`, `annulation_possible`) VALUES
(1, 1, 1, 1, 1, 'Business', 'CB', '2024-06-27', 1),
(2, 2, 1, 1, 1, 'Business', 'CB', '2024-06-27', 1),
(3, 3, 3, 2, 2, 'Economy', 'CB', '2024-07-03', 0);

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

CREATE TABLE `vol` (
  `num_vol` int(11) NOT NULL,
  `id_compagnie` int(11) NOT NULL,
  `date_heure_depart` datetime NOT NULL,
  `lieu_depart` varchar(25) NOT NULL,
  `date_heure_arrivee` datetime NOT NULL,
  `lieu_arrivee` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Déchargement des données de la table `vol`
--

INSERT INTO `vol` (`num_vol`, `id_compagnie`, `date_heure_depart`, `lieu_depart`, `date_heure_arrivee`, `lieu_arrivee`) VALUES
(1, 1, '2024-12-27 16:52:00', 'VIENNA', '2024-12-27 21:03:00', 'MADRID'),
(2, 2, '2024-08-10 10:02:00', 'PARIS', '2024-08-10 11:03:00', 'LONDON');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `compagnie`
--
ALTER TABLE `compagnie`
  ADD PRIMARY KEY (`id_compagnie`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id_reservation`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `num_vol` (`num_vol`);

--
-- Index pour la table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`num_vol`),
  ADD KEY `id_compagnie` (`id_compagnie`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `compagnie`
--
ALTER TABLE `compagnie`
  MODIFY `id_compagnie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id_reservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `vol`
--
ALTER TABLE `vol`
  MODIFY `num_vol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`num_vol`) REFERENCES `vol` (`num_vol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `vol`
--
ALTER TABLE `vol`
  ADD CONSTRAINT `vol_ibfk_1` FOREIGN KEY (`id_compagnie`) REFERENCES `compagnie` (`id_compagnie`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
