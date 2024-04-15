public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] temperatureData = new float[patientsCount];
        for (int i = 0; i < temperatureData.length; i++) {
            temperatureData[i] = (float) (32.0F + (Math.random() * (40.0F - 32.0F)));
        }

        return temperatureData;
    }

    public static String getReport(float[] temperatureData) {

        int healthyPatients = 0;
        float temperatureSum = 0.0F;
        String patientsTemperatures = "";

        for (float temperatureDatum : temperatureData) {
            temperatureSum += temperatureDatum;
            float thisTemperature = (Math.round(temperatureDatum * 10.0F) / 10.0F);
            patientsTemperatures = patientsTemperatures.concat(String.valueOf(thisTemperature)).concat(" ");
            if (temperatureDatum >= 36.2F && temperatureDatum <= 36.9F) {
                healthyPatients++;
            }
        }
        float averageTemperature = temperatureSum / temperatureData.length;

        return "Температуры пациентов: " + patientsTemperatures + "\n"
                + "Средняя температура: " + (Math.round(averageTemperature * 100.0F) / 100.0F) + "\n"
                + "Количество здоровых: " + healthyPatients;
    }
}