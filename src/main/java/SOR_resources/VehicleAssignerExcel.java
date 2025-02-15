package SOR_resources;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
public class VehicleAssignerExcel {

	
		private static final List<String> VEHICLE_LIST = Arrays.asList("MH 48 AY 8693", "MH 01 DR 0540",
				"MH 01 DR 0541", "MH 01 DR 0542", "MH 02 FG 9195", "MH 48 AY 8695", "MH 48 DC 2772", "MH 48 DC 2781",
				"MH 48 DC 2835", "MH 48 DC 2790", "MH 48 DC 2826", "MH 48 AY 8697", "MH 48 AY 8698", "MH 48 AY 8699",
				"MH 48 BM 4360", "MH 48 BM 4361", "MH 48 BM 4356", "MH 48 DC 2817", "MH 48 BM 4358", "MH 48 AY 8701",
				"MH 48 BM 4357", "MH 48 BM 4363", "MH 02 FG 9196");

		private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		private static final long THREE_HOURS_IN_MS = 3 * 60 * 60 * 1000;

		private static final Map<String, Date> lastAssignedVehicles = new HashMap<>();

		public static String assignVehicle(String date, String startTime) throws ParseException {
			if (date.isEmpty() || startTime.isEmpty()) {
				throw new IllegalArgumentException("Date or time cannot be empty");
			}

			Date currentTime = DATE_FORMAT.parse(date + " " + startTime);
			List<String> availableVehicles = new ArrayList<>();

			for (String vehicle : VEHICLE_LIST) {
				if (!lastAssignedVehicles.containsKey(vehicle)) {
					availableVehicles.add(vehicle);
				} else {
					Date lastAssignedTime = lastAssignedVehicles.get(vehicle);
					long timeDifference = Math.abs(currentTime.getTime() - lastAssignedTime.getTime());

					if (timeDifference > THREE_HOURS_IN_MS) {
						availableVehicles.add(vehicle);
					}
				}
			}

			if (availableVehicles.isEmpty()) {
				throw new IllegalStateException("No available vehicles found.");
			}

			Collections.shuffle(availableVehicles);
			String assignedVehicle = availableVehicles.get(0);
			lastAssignedVehicles.put(assignedVehicle, currentTime);

			return assignedVehicle;
		}

		public static String getCellValueAsString(Cell cell) {
			if (cell == null)
				return "";
			switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue().trim();
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(cell.getDateCellValue());
				} else {
					return String.valueOf((long) cell.getNumericCellValue());
				}
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			default:
				return "";
			}
		}

		public static void processExcel(String filePath) throws Exception {
			FileInputStream fis = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				if (row.getRowNum() == 0)
					continue; // Skip header

				Cell dateCell = row.getCell(1);
				Cell timeCell = row.getCell(2);
				Cell vehicleCell = row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

				String date = getCellValueAsString(dateCell);
				String startTime = getCellValueAsString(timeCell);

				if (date.isEmpty() || startTime.isEmpty()) {
					System.out.println("Skipping row " + row.getRowNum() + " due to missing date/time");
					continue;
				}

				if (startTime.matches("\\d{1,2}")) { // Handle cases where time is only hours (e.g., "0")
					startTime = String.format("%02d:00", Integer.parseInt(startTime));
				}

				try {
					String assignedVehicle = assignVehicle(date, startTime);
					vehicleCell.setCellValue(assignedVehicle);
				} catch (ParseException | IllegalArgumentException e) {
					System.out.println(
							"Skipping row " + row.getRowNum() + " due to invalid date/time format: " + e.getMessage());
					continue;
				}
			}

			fis.close();
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			workbook.write(fos);
			workbook.close();
			fos.close();
		}

		public static void main(String[] args) throws Exception {
			String filePath = "C:\\Users\\rajendra.mane\\Desktop\\Sor_Report\\VD\\Feb_2025.xlsx"; // Path to your
																										// Excel file
			processExcel(filePath);
			System.out.println("Excel file updated with assigned vehicles.");
		}
	}
*/



public class VehicleAssignerExcel {
    private static final List<String> VEHICLE_LIST = Arrays.asList(
        "MH 48 AY 8693", "MH 01 DR 0540", "MH 01 DR 0541", "MH 01 DR 0542",
        "MH 02 FG 9195", "MH 48 AY 8695", "MH 48 DC 2772", "MH 48 DC 2781",
        "MH 48 DC 2835", "MH 48 DC 2790", "MH 48 DC 2826", "MH 48 AY 8697",
        "MH 48 AY 8698", "MH 48 AY 8699", "MH 48 BM 4360", "MH 48 BM 4361",
        "MH 48 BM 4356", "MH 48 DC 2817", "MH 48 BM 4358", "MH 48 AY 8701",
        "MH 48 BM 4357", "MH 48 BM 4363", "MH 02 FG 9196"
    );
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private static final long THREE_HOURS_IN_MS = 3 * 60 * 60 * 1000;
    
    private static final LinkedHashMap<String, Date> lastAssignedVehicles = new LinkedHashMap<>();
    
    public static String assignVehicle(String date, String startTime, Sheet sheet, int currentRow) throws ParseException {
        Date currentTime = DATE_FORMAT.parse(date + " " + startTime);
        
        for (String vehicle : VEHICLE_LIST) {
            boolean isAvailable = true;
            
            for (int i = 1; i < currentRow; i++) {
                Row prevRow = sheet.getRow(i);
                if (prevRow == null) continue;
                
                String prevDate = getCellValueAsString(prevRow.getCell(1));
                String prevStartTime = getCellValueAsString(prevRow.getCell(2));
                String prevVehicle = getCellValueAsString(prevRow.getCell(7));
                
                if (!prevVehicle.isEmpty() && prevVehicle.equals(vehicle)) {
                    Date prevTime = DATE_FORMAT.parse(prevDate + " " + prevStartTime);
                    if (Math.abs(currentTime.getTime() - prevTime.getTime()) <= THREE_HOURS_IN_MS) {
                        isAvailable = false;
                        break;
                    }
                }
            }
            
            if (isAvailable) {
                lastAssignedVehicles.put(vehicle, currentTime);
                return vehicle;
            }
        }
        return "No Available Vehicle";
    }
    
    public static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(cell.getDateCellValue());
                } else {
                    return String.valueOf((long) cell.getNumericCellValue());
                }
            default:
                return "";
        }
    }
    
    public static void processExcel(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;
            
            Cell dateCell = row.getCell(1);
            Cell timeCell = row.getCell(2);
            Cell vehicleCell = row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            
            String date = getCellValueAsString(dateCell).trim();
            String startTime = getCellValueAsString(timeCell).trim();
            String existingVehicle = getCellValueAsString(vehicleCell).trim();
            
            if (date.isEmpty() || startTime.isEmpty()) {
                System.out.println("Skipping row " + (row.getRowNum() + 1) + " due to missing date/time");
                continue;
            }
            
            if (!existingVehicle.isEmpty()) {
                lastAssignedVehicles.put(existingVehicle, DATE_FORMAT.parse(date + " " + startTime));
                continue;
            }
            
            try {
                String assignedVehicle = assignVehicle(date, startTime, sheet, row.getRowNum());
                vehicleCell.setCellValue(assignedVehicle);
            } catch (ParseException e) {
                System.out.println("Skipping row " + (row.getRowNum() + 1) + " due to invalid date/time format: " + e.getMessage());
            }
        }
        
        fis.close();
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        workbook.write(fos);
        workbook.close();
        fos.close();
    }
    
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\rajendra.mane\\Desktop\\Sor_Report\\VD\\Feb_2025.xlsx";
        processExcel(filePath);
        System.out.println("Excel file updated with assigned vehicles.");
    }
}








