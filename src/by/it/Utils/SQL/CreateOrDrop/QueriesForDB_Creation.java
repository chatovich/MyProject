package by.it.Utils.SQL.CreateOrDrop;

import by.it.Utils.SQL.OtherSqlMethods.Insert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 * methods for DB creation and update
 */
public class QueriesForDB_Creation {

    public static void createTable(Statement statement) throws Exception {

        statement.executeUpdate("CREATE TABLE `allbuildings` (\n" +
                "  `id.allbuildings` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `dateofbuilding` DATETIME NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

        statement.executeUpdate("CREATE TABLE `aperture` (\n" +
                "  `id.aperture` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `typeOfAperture` varchar(100) NOT NULL,\n" +
                "  `width` double NOT NULL,\n" +
                "  `height` double NOT NULL,\n" +
                "  `count` tinyint NOT NULL,\n" +
                "  `squareOfAperture` double NOT NULL,\n" +
                "  `fk.id.room` int(11) NOT NULL \n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

        statement.executeUpdate("CREATE TABLE `building` (\n" +
                "  `id.building` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `nameOfBuilding` varchar(100) NOT NULL,\n" +
                "  `selectedTemperatureOfRegion` double NOT NULL,\n" +
                "  `specifyingCoefficientS5` double NOT NULL,\n" +
                "  `fk.id.user` int(11) NOT NULL,\n" +
                "  `fk.id.allbuildings` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");


        statement.executeUpdate("CREATE TABLE `coefficientsforbuilding` (\n" +
                "  `id.coefficientSForBuilding` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `fk.id.building` int(11) NOT NULL,\n" +
                "  `s2` double NOT NULL,\n" +
                "  `s3` double NOT NULL,\n" +
                "  `s5` double NOT NULL,\n" +
                "  `s6` double NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");


        statement.executeUpdate("CREATE TABLE `coefficientsforroom` (\n" +
                "  `id.coefficientsforroom` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `fk.id.room` int(11) NOT NULL,\n" +
                "  `s1` double NOT NULL,\n" +
                "  `s4` double NOT NULL,\n" +
                "  `s7` double NOT NULL,\n" +
                "  `s8` double NOT NULL,\n" +
                "  `s9` double NOT NULL,\n" +
                "  `s10` double NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

        statement.executeUpdate("CREATE TABLE `flammablesubstance` (\n" +
                "  `id.substance` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `nameOfSubstance` varchar(100) NOT NULL,\n" +
                "  `amountOfCombustionAir` double NOT NULL,\n" +
                "  `combustionHeat` double NOT NULL,\n" +
                "  `averageSpeedBurnout` double NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

        statement.executeUpdate("CREATE TABLE `room` (\n" +
                "  `id.room` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `positionOfRoom` varchar(100) NOT NULL,\n" +
                "  `nameOfRoom` varchar(100) NOT NULL,\n" +
                "  `square` double NOT NULL,\n" +
                "  `height` double NOT NULL,\n" +
                "  `perimeter` double NOT NULL,\n" +
                "  `volume` double NOT NULL,\n" +
                "  `squareOfConstruction` double NOT NULL,\n" +
                "  `specificFireLoad` double NOT NULL,\n" +
                "  `specificFireLoadZVEZDOCHKA` double,\n" +
                "  `reducedHeightOfApertures` double NOT NULL,\n" +
                "  `generalSquareOfApertures` double NOT NULL,\n" +
                "  `ventilationParameter` double NOT NULL,\n" +
                "  `coefficientK` double NOT NULL,\n" +
                "  `coefficientA` double NOT NULL,\n" +
                "  `coefficientB` double NOT NULL,\n" +
                "  `coefficientS` double NOT NULL,\n" +
                "  `estimatedFireLoad` double NOT NULL,\n" +
                "  `proemnostOfRoom` double NOT NULL,\n" +
                "  `averageAmountOfCombustionAir` double NOT NULL,\n" +
                "  `specificCriticalAmountOfFireLoad` double NOT NULL,\n" +
                "  `specificValueOfFireLoad` double NOT NULL,\n" +
                "  `PRN` tinyint(1) NOT NULL,\n" +
                "  `maximumMeanBulkTemperature` double NOT NULL,\n" +
                "  `durationOfFireSurround` double NOT NULL,\n" +
                "  `timeReachMaximumMeanBulkTemperature` double NOT NULL,\n" +
                "  `maximumAverageTemperatureOfWallSurface` double NOT NULL,\n" +
                "  `timeToReachMaximumTemperatureOfWallSurface` double NOT NULL,\n" +
                "  `averageMaximumTemperatureOfSlab` double NOT NULL,\n" +
                "  `timeToReachMaximumTemperatureOfSlabSurface` double NOT NULL,\n" +
                "  `fk.id.building` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

        statement.executeUpdate("CREATE TABLE `substancesofroom` (\n" +
                "  `id.substancesOfRoom` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `fk.id.substance` int(11) NOT NULL,\n" +
                "  `fk.id.room` int(11) NOT NULL,\n" +
                "  `weight` double NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

        statement.executeUpdate("CREATE TABLE `users` (\n" +
                "  `id.user` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `login` varchar(100) NOT NULL,\n" +
                "  `password` varchar(100) NOT NULL,\n" +
                "  `email` varchar(100) NOT NULL,\n" +
                "  `admin` tinyint(1) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<121;i++){
            StringBuilder sb1=new StringBuilder("`t"+i+"` double NOT NULL,\n");
            sb.append(sb1);
        }
        statement.executeUpdate("CREATE TABLE `changesinmeanbulktemperature` (\n" +
                "  `id.changesinmeanbulktemperature` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                    sb+
                "  `fk.id.room` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        statement.executeUpdate("CREATE TABLE `changeinaveragetemperatureofwalls` (\n" +
                "  `id.changeinaveragetemperatureofwalls` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                sb+
                "  `fk.id.room` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

        statement.executeUpdate("CREATE TABLE `changeinaveragetemperatureofslab` (\n" +
                "  `id.changeinaveragetemperatureofslab` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                sb+
                "  `fk.id.room` int(11) NOT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

/**
 * Description of FOREIGN KEY-s
 */

        statement.executeUpdate("ALTER TABLE `changesinmeanbulktemperature`\n" +
                "  ADD CONSTRAINT `changesinmeanbulktemperature_ibfk_1` FOREIGN KEY (`fk.id.room`) REFERENCES `room` (`id.room`)" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `changeinaveragetemperatureofwalls`\n" +
                "  ADD CONSTRAINT `changeinaveragetemperatureofwalls_ibfk_1` FOREIGN KEY (`fk.id.room`) REFERENCES `room` (`id.room`)" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `changeinaveragetemperatureofslab`\n" +
                "  ADD CONSTRAINT `changeinaveragetemperatureofslab_ibfk_1` FOREIGN KEY (`fk.id.room`) REFERENCES `room` (`id.room`)" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `aperture`\n" +
                "  ADD CONSTRAINT `aperture_ibfk_1` FOREIGN KEY (`fk.id.room`) REFERENCES `room` (`id.room`)" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `building`\n" +
                "  ADD CONSTRAINT `building_ibfk_1` FOREIGN KEY (`fk.id.user`) REFERENCES `users` (`id.user`)\n" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `building`\n" +
                "  ADD CONSTRAINT `building_ibfk_2` FOREIGN KEY (`fk.id.allbuildings`) REFERENCES `allbuildings` (`id.allbuildings`)" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `coefficientsforbuilding`\n" +
                "  ADD CONSTRAINT `coefficientsforbuilding_ibfk_1` FOREIGN KEY (`fk.id.building`) REFERENCES `building` (`id.building`)" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `coefficientsforroom`\n" +
                "  ADD CONSTRAINT `coefficientsforroom_ibfk_1` FOREIGN KEY (`fk.id.room`) REFERENCES `room` (`id.room`)" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `room`\n" +
                "  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`fk.id.building`) REFERENCES `building` (`id.building`)" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `substancesofroom`\n" +
                "  ADD CONSTRAINT `substancesofroom_ibfk_1` FOREIGN KEY (`fk.id.substance`) REFERENCES `flammablesubstance` (`id.substance`)\n" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");

        statement.executeUpdate("ALTER TABLE `substancesofroom`\n" +
                "ADD CONSTRAINT `substancesofroom_ibfk_2` FOREIGN KEY (`fk.id.room`) REFERENCES `room` (`id.room`)" +
                "ON DELETE CASCADE\n" +
                "ON UPDATE CASCADE\n");
    }

    public static void insertData () throws SQLException {
        Insert.addToFlammableSubstance("Древесина", 4.2, 13.8, 2.4);
        Insert.addToFlammableSubstance("Изоляция проводов, кабелей ПВХ", 13.05, 33.5, 3.73);
        Insert.addToFlammableSubstance("Масло", 10.5, 42.3, 2.1);
        Insert.addToFlammableSubstance("Пластмасса (Полиэтилен)", 11.42,47.14, 0.62);
        Insert.addToFlammableSubstance("РТИ", 13.18, 33.52, 0.9);
        Insert.addToFlammableSubstance("Текстильные изделия",2.12,16.7,1.44);
        Insert.addToUsers("henk","guevara333","henk@pochta.ru",true);
    }

    public static void showTables (Statement statement) throws SQLException {

        Calendar today = Calendar.getInstance();
        ResultSet resultSet = statement.executeQuery("select * from users;");
        while (resultSet.next()){
            Calendar birthday = Calendar.getInstance();
            birthday.setTime(resultSet.getDate("birth_date"));
            int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
            System.out.println(resultSet.getString("name")+" "+resultSet.getString("surname")+", age "+age);
        }

    }
}
