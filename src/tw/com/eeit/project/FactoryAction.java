package tw.com.eeit.project;

import java.util.Scanner;

public class FactoryAction {

	public static void main(String[] args) throws Exception {

		IFactoryDao fDao = FactoryDao.createFactoryDao();
		fDao.createConn();
		

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("請選擇功能");
			System.out.println("(0) 匯入資料");
			System.out.println("(1) 查詢資料");
			System.out.println("(2) 新增資料");
			System.out.println("(3) 修改資料");
			System.out.println("(4) 刪除資料");
			System.out.println("(5) 下載資料圖片");
			System.out.println("(6) 退出程式");
			int userInput = scan.nextInt();
			

			if (userInput == 0) {
				fDao.fileInput();
			}
			if (userInput == 1) {
				System.out.println("請選擇要查詢的方式");
				System.out.println("(1) 編號");
				System.out.println("(2) 地區");
				System.out.println("(3) 縣市");
				int userInput2 = scan.nextInt();
				if (userInput2 == 1) {
					System.out.println("請輸入要查詢的資料編號");
					int userInputid = scan.nextInt();
					fDao.findById(userInputid);
					System.out.println("-------------------------");
				}
				if (userInput2 == 2) {
					System.out.println("請輸入要查詢的觀光工廠所在地區");
					String userInputArea = scan.next();
					fDao.findByArea(userInputArea);
					System.out.println("-------------------------");
				}
				if (userInput2 == 3) {
					System.out.println("請輸入要查詢的觀光工廠所在縣市");
					String userInputCity = scan.next();
					fDao.findByCity(userInputCity);
					System.out.println("-------------------------");
				}

			}
			if (userInput == 2) {
				System.out.println("請輸入Area");
				String area = scan.next();
				System.out.println("請輸入City");
				String city = scan.next();
				System.out.println("請輸入Name");
				String name = scan.next();
				System.out.println("請輸入Address");
				String address = scan.next();
				System.out.println("請輸入Phone");
				String phone = scan.next();
				System.out.println("請輸入Website");
				String website = scan.next();
				Factory f2 = new Factory(area, city, name, address, phone, website);
				fDao.add(f2);
				System.out.println("-------------------------");
			}
			if (userInput == 3) {
				System.out.println("請輸入要修改的資料編號");
				int userInputId2 = scan.nextInt();
				System.out.println("請輸入要修改的內容（地區、縣市、地址、電話)");
				String userInput3 = scan.next();
				String[] userInput4 = userInput3.split("、");
				Factory f3 = new Factory(userInput4[0], userInput4[1], userInput4[2], userInput4[3], userInputId2);
				fDao.update(f3);
				System.out.println("-------------------------");
			}
			if (userInput == 4) {
				System.out.println("請輸入要刪除的資料編號");
				int userInputId3 = scan.nextInt();
				fDao.deleteById(userInputId3);
				System.out.println("-------------------------");
			}
			if (userInput == 5) {
				fDao.imageInput();
				System.out.println("請輸入要下載的資料圖片編號");
//				System.out.println("(1) 新增");
//				System.out.println("(2) 下載");
				int userInput4 = scan.nextInt();
				fDao.imageRetrieve(userInput4);
				System.out.println("-------------------------");
//				if (userInput4 == 1) {
//					System.out.println("請輸入要新增圖片的資料編號");
//					int userInputId4 = scan.nextInt();
//					fDao.imageInput(userInputId4);
//					System.out.println("-------------------------");
//				}
//				if (userInput4 == 2) {
//					System.out.println("請輸入要下載圖片的資料編號");
//					int userInputId4 = scan.nextInt();
//					fDao.imageRetrieve(userInputId4);
//					System.out.println("-------------------------");
//				}
			}
			if (userInput == 6) {
				break;
			}
		}
		scan.close();
		fDao.closeConn();
	}
}
