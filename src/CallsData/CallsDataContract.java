package CallsData;

/**
 *
 * @author joaop
 */
public interface CallsDataContract {
    /**
     * Calculates the average minutes per number
     * 
     * @return 
     */
    public double calculateAverageMinutesPerNumber();
    
    /**
     * Calculates the average minutes per area
     * 
     * @param area_code The area code
     * @param outputFileName The name of the file to store the info
     * @return 
     */
    public double calculateAverageMinutesPerArea(String area_code, String outputFileName);
}
