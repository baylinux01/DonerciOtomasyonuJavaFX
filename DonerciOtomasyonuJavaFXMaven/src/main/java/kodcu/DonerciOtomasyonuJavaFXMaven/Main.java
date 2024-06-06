package kodcu.DonerciOtomasyonuJavaFXMaven;
	
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Dao dao=new Dao();
			dao.createDatabase();
			
//			if(!dao.doesTableExistInDb("ProductPriceTable"))
//			{
//				dao.createProductPriceTable();
//			}
			dao.createProductNameAndPriceTable();
			dao.createProductTable();
//			ObservableList<Product> orderProducts=FXCollections.observableArrayList();
//			ObservableList<Product> selledProducts=FXCollections.observableArrayList();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			List<Product> orderProducts=new ArrayList<Product>();
			
			Group root = new Group();
			
			Label label=new Label("Eklenecek Ürün Adı:");
			label.setPrefSize(170, 20);
			label.setLayoutX(20);
			label.setLayoutY(27);
			label.setAlignment(Pos.BASELINE_RIGHT);
			root.getChildren().add(label);
			
			Label label1=new Label("Eklenecek Ürün Fiyatı:");
			label1.setPrefSize(170, 20);
			label1.setLayoutX(20);
			label1.setLayoutY(67);
			label1.setAlignment(Pos.BASELINE_RIGHT);
			root.getChildren().add(label1);
			
			TextField textfield=new TextField();
			textfield.setPrefSize(150, 20);
			textfield.setLayoutX(200);
			textfield.setLayoutY(20);
			root.getChildren().add(textfield);
			
			TextField textfield1=new TextField();
			textfield1.setPrefSize(150, 20);
			textfield1.setLayoutX(200);
			textfield1.setLayoutY(60);
			root.getChildren().add(textfield1);
			
			Label label2=new Label("Toplam:");
			label2.setPrefSize(170, 20);
			label2.setLayoutX(570);
			label2.setLayoutY(362);
			label2.setAlignment(Pos.BASELINE_RIGHT);
			root.getChildren().add(label2);
			
			TextField textfield2=new TextField();
			textfield2.setPrefSize(170, 20);
			textfield2.setLayoutX(745);
			textfield2.setLayoutY(355);
			textfield2.setEditable(false);
			textfield2.setAlignment(Pos.BASELINE_RIGHT);
			root.getChildren().add(textfield2);
			

			
			Label label3=new Label("Toplam:");
			label3.setPrefSize(180, 20);
			label3.setLayoutX(950);
			label3.setLayoutY(437);
			label3.setAlignment(Pos.BASELINE_RIGHT);
			root.getChildren().add(label3);
			
			TextField textfield3=new TextField();
			textfield3.setPrefSize(180, 20);
			textfield3.setLayoutX(1135);
			textfield3.setLayoutY(430);
			textfield3.setEditable(false);
			textfield3.setAlignment(Pos.BASELINE_RIGHT);
			root.getChildren().add(textfield3);
			
//			Button button7=new Button("Siparişi Yazdır");
//			button7.setPrefSize(170, 20);
//			button7.setLayoutX(745);
//			button7.setLayoutY(600);
//			button7.setOnAction(eh7);
//			root.getChildren().add(button7);
			
			Label label4=new Label("Müşteri Adı Soyadı:");
			label4.setPrefSize(180, 20);
			label4.setLayoutX(560);
			label4.setLayoutY(467);
			label4.setAlignment(Pos.BASELINE_RIGHT);
			root.getChildren().add(label4);
			
			TextField textfield4=new TextField();
			textfield4.setPrefSize(180, 20);
			textfield4.setLayoutX(745);
			textfield4.setLayoutY(460);
			root.getChildren().add(textfield4);
			
			Label label5=new Label("Müşteri Telefon Numarası:");
			label5.setPrefSize(180, 20);
			label5.setLayoutX(560);
			label5.setLayoutY(497);
			label5.setAlignment(Pos.BASELINE_RIGHT);
			root.getChildren().add(label5);
			
			TextField textfield5=new TextField();
			textfield5.setPrefSize(180, 20);
			textfield5.setLayoutX(745);
			textfield5.setLayoutY(490);
			root.getChildren().add(textfield5);
			
			Label label6=new Label("Müşteri Adres:");
			label6.setPrefSize(180, 20);
			label6.setLayoutX(560);
			label6.setLayoutY(527);
			label6.setAlignment(Pos.BASELINE_RIGHT);
			root.getChildren().add(label6);
			
			TextArea textarea6=new TextArea();
			textarea6.setPrefSize(180, 60);
			textarea6.setLayoutX(745);
			textarea6.setLayoutY(520);
			textarea6.setWrapText(true);
			root.getChildren().add(textarea6);
			
			ListView listview=new ListView();
			listview.setPrefSize(170, 150);
			listview.setLayoutX(20);
			listview.setLayoutY(140);
			listview.getItems().addAll(dao.getProductNames());
			listview.getSelectionModel().select(0);
			root.getChildren().add(listview);
			
			ListView listview1=new ListView();
			listview1.setPrefSize(170, 150);
			listview1.setLayoutX(20);
			listview1.setLayoutY(300);
			listview1.getItems().addAll("Normal Ekmekli","Yarım EKmekli","1.5 Ekmekli",
					"2 Ekmekli","2.5 Ekmekli","3 Ekmekli");
			listview1.getSelectionModel().select(0);
			root.getChildren().add(listview1);
			
			ListView listview2=new ListView();
			listview2.setPrefSize(150, 150);
			listview2.setLayoutX(200);
			listview2.setLayoutY(300);
			listview2.getItems().addAll("Normal Ketçaplı","Ketçapsız","Az Ketçaplı","Bol Ketçaplı");
			listview2.getSelectionModel().select(0);
			root.getChildren().add(listview2);
			
			ListView listview3=new ListView();
			listview3.setPrefSize(170, 150);
			listview3.setLayoutX(20);
			listview3.setLayoutY(460);
			listview3.getItems().addAll("Normal Mayonezli","Mayonezsiz","Az Mayonezli","Bol Mayonezli");
			listview3.getSelectionModel().select(0);
			root.getChildren().add(listview3);
			
			ListView listview4=new ListView();
			listview4.setPrefSize(150, 150);
			listview4.setLayoutX(200);
			listview4.setLayoutY(460);
			listview4.getItems().addAll("Normal Soslu","Sossuz","Az Soslu","Bol Soslu");
			listview4.getSelectionModel().select(0);
			root.getChildren().add(listview4);
			
			ListView listview5=new ListView();
			listview5.setPrefSize(150, 150);
			listview5.setLayoutX(200);
			listview5.setLayoutY(140);
			listview5.getItems().addAll("Normal Patatesli","Patatessiz","Az Patatesli","Bol Patatesli");
			listview5.getSelectionModel().select(0);
			root.getChildren().add(listview5);
			
			ListView listview6=new ListView();
			listview6.setPrefSize(150, 150);
			listview6.setLayoutX(360);
			listview6.setLayoutY(140);
			listview6.getItems().addAll("Normal Soğanlı","Soğansız","Az Soğanlı","Bol Soğanlı");
			listview6.getSelectionModel().select(0);
			root.getChildren().add(listview6);
			
			ListView listview7=new ListView();
			listview7.setPrefSize(150, 150);
			listview7.setLayoutX(360);
			listview7.setLayoutY(300);
			listview7.getItems().addAll("Normal Baharatlı","Baharatsız","Az Baharatlı","Bol Baharatlı");
			listview7.getSelectionModel().select(0);
			root.getChildren().add(listview7);
			
			ListView listview8=new ListView();
			listview8.setPrefSize(150, 150);
			listview8.setLayoutX(360);
			listview8.setLayoutY(460);
			listview8.getItems().addAll("Normal Tuzlu","Tuzsuz","Az Tuzlu","Bol Tuzlu");
			listview8.getSelectionModel().select(0);
			root.getChildren().add(listview8);
			
			TableView<Product> tableview=new TableView<Product>();
			tableview.setPrefSize(315, 315);
			tableview.setLayoutX(600);
			tableview.setLayoutY(20);
			root.getChildren().add(tableview);
			
			TableColumn<Product, String> col1=new TableColumn<Product, String>("Ürün Adı");
			TableColumn<Product, String> col2=new TableColumn<Product, String>("Özellik");
			TableColumn<Product, Integer> col3=new TableColumn<Product, Integer>("Aded");
			TableColumn<Product, Double> col4=new TableColumn<Product, Double>("Fiyat");
			TableColumn<Product, Double> col5=new TableColumn<Product, Double>("Toplam");
			
			col1.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
			col2.setCellValueFactory(new PropertyValueFactory<Product, String>("property"));
			col3.setCellValueFactory(new PropertyValueFactory<Product, Integer>("number"));
			col4.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
			col5.setCellValueFactory(new PropertyValueFactory<Product, Double>("total"));
			
			
			col1.setMinWidth(120);
			col1.setMaxWidth(120);
			col2.setMinWidth(80);
			col2.setMaxWidth(80);
			col3.setMaxWidth(35);
			col4.setMaxWidth(35);
			col5.setMaxWidth(45);
			
			col1.setStyle("-fx-font:normal bold 10px 'serif' ");
			col2.setStyle("-fx-font:normal bold 10px 'serif' ");
			col3.setStyle("-fx-font:normal bold 10px 'serif' ");
			col4.setStyle("-fx-font:normal bold 10px 'serif' ");
			col5.setStyle("-fx-font:normal bold 10px 'serif' ");
			
			tableview.getColumns().add(col1);
			tableview.getColumns().add(col2);
			tableview.getColumns().add(col3);
			tableview.getColumns().add(col4);
			tableview.getColumns().add(col5);
			//tableview.autosize();
			
			TableView<Product> tableview1=new TableView<Product>();
			tableview1.setPrefSize(315, 400);
			tableview1.setLayoutX(1000);
			tableview1.setLayoutY(20);
			root.getChildren().add(tableview1);
			
			TableColumn<Product, String> col11=new TableColumn<Product, String>("Ürün Adı");
			//TableColumn<Product, String> col21=new TableColumn<Product, String>("Özellik");
			TableColumn<Product, Integer> col31=new TableColumn<Product, Integer>("Aded");
			TableColumn<Product, Double> col41=new TableColumn<Product, Double>("Fiyat");
			TableColumn<Product, Double> col51=new TableColumn<Product, Double>("Toplam");
			TableColumn<Product, Double> col61=new TableColumn<Product, Double>("Tarih");
			
			col11.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
			//col21.setCellValueFactory(new PropertyValueFactory<Product, String>("property"));
			col31.setCellValueFactory(new PropertyValueFactory<Product, Integer>("number"));
			col41.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
			col51.setCellValueFactory(new PropertyValueFactory<Product, Double>("total"));
			col61.setCellValueFactory(new PropertyValueFactory<Product, Double>("date"));
			
			col11.setMinWidth(120);
			col11.setMaxWidth(120);
			//col21.setMinWidth(80);
			//col21.setMaxWidth(80);
			col31.setMaxWidth(35);
			col41.setMaxWidth(35);
			col51.setMaxWidth(45);
			col61.setMinWidth(80);
			col61.setMaxWidth(80);
			
			
			col11.setStyle("-fx-font:normal bold 10px 'serif' ");
			//col21.setStyle("-fx-font:normal bold 10px 'serif' ");
			col31.setStyle("-fx-font:normal bold 10px 'serif' ");
			col41.setStyle("-fx-font:normal bold 10px 'serif' ");
			col51.setStyle("-fx-font:normal bold 10px 'serif' ");
			col61.setStyle("-fx-font:normal bold 10px 'serif' ");
			
			tableview1.getColumns().add(col11);
			//tableview1.getColumns().add(col21);
			tableview1.getColumns().add(col31);
			tableview1.getColumns().add(col41);
			tableview1.getColumns().add(col51);
			tableview1.getColumns().add(col61);
			
			List<Product> selledProducts0=dao.bringProductTableContent();
			tableview1.getItems().clear();
			double selledTotal=0;
			for(Product sep: selledProducts0)
			{
				selledTotal+=sep.getTotal();
			}
			textfield3.setText(selledTotal+"");
			selledTotal=0;
			tableview1.getItems().addAll(selledProducts0);
			//tableview1.setItems(selledProducts0);
			
			EventHandler eh=new EventHandler()
			{

				@Override
				public void handle(Event arg0) {
					Dao dao=new Dao();
					int result=0;
					try {
						result = dao.saveItemToProductNameAndPriceTable(textfield.getText(),textfield1.getText());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(result);
					if(result==1) 
					{
						textfield.setText("");
						textfield1.setText("");
						try {
							listview.setItems(dao.getProductNames());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
			};
			
			Button button=new Button("Ürün Oluştur");
			button.setPrefSize(150, 20);
			button.setLayoutX(200);
			button.setLayoutY(100);
			button.setOnAction(eh);
			root.getChildren().add(button);
			
			EventHandler eh1=new EventHandler()
			{

				@Override
				public void handle(Event arg0) {
					Dao dao=new Dao();
					int result=0;
					try {
						result = dao.deleteFromProductNameAndPriceTable(listview.getSelectionModel().getSelectedItem()+"");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(result==1) 
					{
						textfield.setText("");
						textfield1.setText("");
						try {
							listview.setItems(dao.getProductNames());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
			};
			
			Button button1=new Button("Ürün Sil");
			button1.setPrefSize(170, 20);
			button1.setLayoutX(20);
			button1.setLayoutY(100);
			button1.setOnAction(eh1);
			root.getChildren().add(button1);
			
			EventHandler eh2=new EventHandler()
			{

				@Override
				public void handle(Event arg0) {
					Product product=new Product();
					//System.out.println(listview.getSelectionModel().getSelectedItem());
					String productName=listview.getSelectionModel().getSelectedItem()+"";
					product.setName(productName);
					

					if(listview1.getSelectionModel().getSelectedItem()!=null &&
							!listview1.getSelectionModel().getSelectedItem().equals("Normal Ekmekli"))
					{
						if(product.getProperty().equals(""))
						product.setProperty(product.getProperty()+listview1
								.getSelectionModel().getSelectedItem());
						else
							product.setProperty(product.getProperty()+"\n"+listview1
									.getSelectionModel().getSelectedItem());
					}
					if(listview2.getSelectionModel().getSelectedItem()!=null &&
							!listview2.getSelectionModel().getSelectedItem().equals("Normal Ketçaplı"))
					{
						if(product.getProperty().equals(""))
						product.setProperty(product.getProperty()+listview2
								.getSelectionModel().getSelectedItem());
						else
							product.setProperty(product.getProperty()+"\n"+listview2
									.getSelectionModel().getSelectedItem());
					}
					if(listview3.getSelectionModel().getSelectedItem()!=null &&
							!listview3.getSelectionModel().getSelectedItem().equals("Normal Mayonezli"))
					{
						if(product.getProperty().equals(""))
						product.setProperty(product.getProperty()+listview3
								.getSelectionModel().getSelectedItem());
						else
							product.setProperty(product.getProperty()+"\n"+listview3
									.getSelectionModel().getSelectedItem());
					}
					if(listview4.getSelectionModel().getSelectedItem()!=null &&
							!listview4.getSelectionModel().getSelectedItem().equals("Normal Soslu"))
					{
						if(product.getProperty().equals(""))
						product.setProperty(product.getProperty()+listview4
								.getSelectionModel().getSelectedItem());
						else
							product.setProperty(product.getProperty()+"\n"+listview4
									.getSelectionModel().getSelectedItem());
					}
					if(listview5.getSelectionModel().getSelectedItem()!=null &&
							!listview5.getSelectionModel().getSelectedItem().equals("Normal Patatesli"))
					{
						if(product.getProperty().equals(""))
						product.setProperty(product.getProperty()+listview5
								.getSelectionModel().getSelectedItem());
						else
							product.setProperty(product.getProperty()+"\n"+listview5
									.getSelectionModel().getSelectedItem());
					}
					if(listview6.getSelectionModel().getSelectedItem()!=null &&
							!listview6.getSelectionModel().getSelectedItem().equals("Normal Soğanlı"))
					{
						if(product.getProperty().equals(""))
						product.setProperty(product.getProperty()+listview6
								.getSelectionModel().getSelectedItem());
						else
							product.setProperty(product.getProperty()+"\n"+listview6
									.getSelectionModel().getSelectedItem());
					}
					if(listview7.getSelectionModel().getSelectedItem()!=null &&
							!listview7.getSelectionModel().getSelectedItem().equals("Normal Baharatlı"))
					{
						if(product.getProperty().equals(""))
						product.setProperty(product.getProperty()+listview7
								.getSelectionModel().getSelectedItem());
						else
							product.setProperty(product.getProperty()+"\n"+listview7
									.getSelectionModel().getSelectedItem());
					}
					if(listview8.getSelectionModel().getSelectedItem()!=null &&
							!listview8.getSelectionModel().getSelectedItem().equals("Normal Tuzlu"))
					{
						if(product.getProperty().equals(""))
						product.setProperty(product.getProperty()+listview8
								.getSelectionModel().getSelectedItem());
						else
							product.setProperty(product.getProperty()+"\n"+listview8
									.getSelectionModel().getSelectedItem());
					}
					try {
						product.setPrice(Double.valueOf(dao.getProductPrice(product.getName())));
					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					product.setNumber(1);
					product.setTotal(product.getNumber()*product.getPrice());
					product.setDate(LocalDate.now()+"");
					//System.out.println(product.toString());
					Product product1=new Product();
					product1.setName(product.getName());
					product1.setDate(product.getDate());
					product1.setNumber(product.getNumber());
					product1.setPrice(product.getPrice());
					product1.setProperty(product.getProperty());
					product1.setTotal(product.getTotal());
					//System.out.println(product1.toString());
					listview1.getSelectionModel().select(0);
					listview2.getSelectionModel().select(0);
					listview3.getSelectionModel().select(0);
					listview4.getSelectionModel().select(0);
					listview5.getSelectionModel().select(0);
					listview6.getSelectionModel().select(0);
					listview7.getSelectionModel().select(0);
					listview8.getSelectionModel().select(0);
					
//					System.out.println(product.toString());
					if(orderProducts.size()>0)
					{
						int i=0;
						int j=0;
						while(i<orderProducts.size())
						{
							if(orderProducts.get(i).getName().equals(product.getName())
									&&orderProducts.get(i).getProperty().equals(product.getProperty()))
							{
								orderProducts.get(i).setNumber(orderProducts.get(i).getNumber()+1);
								orderProducts.get(i).setTotal(orderProducts.get(i).getNumber()
										*orderProducts.get(i).getPrice());
								
							}
							i++;
						}
						i=0;
						while(i<orderProducts.size())
						{
							if(!orderProducts.get(i).getName().equals(product.getName())
									||!orderProducts.get(i).getProperty().equals(product.getProperty()))
							{
								j++;
							}
							i++;
						}
						if(j==orderProducts.size()) orderProducts.add(product);
						i=0;
						j=0;
						
					}
					else orderProducts.add(product);
					
					tableview.getItems().clear();
					tableview.getItems().addAll(orderProducts);
					double orderTotal=0;
					for(Product op: orderProducts)
					{
						orderTotal+=op.getTotal();
					}
					textfield2.setText(orderTotal+"");
					orderTotal=0;
					//tableview.setItems(orderProducts);
					List<Product> selledProducts=null;
					try {
						selledProducts = dao.bringProductTableContent();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(selledProducts.size()>0)
					{
						int i=0;
						int j=0;
						while(i<selledProducts.size())
						{
							if(selledProducts.get(i).getName().equals(product1.getName())
							&&selledProducts.get(i).getDate().equals(product1.getDate()))
							{
								try {
									dao.increaseProductNumberByAlteringProductTable(selledProducts.get(i).getName() 
										,selledProducts.get(i).getDate(),selledProducts.get(i).getNumber()
										,selledProducts.get(i).getPrice());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
//								selledProducts.get(i).setNumber(selledProducts.get(i).getNumber()+1);
//								selledProducts.get(i).setTotal(selledProducts.get(i).getNumber()
//										*selledProducts.get(i).getPrice());
							}
							i++;
						}
						i=0;
						while(i<selledProducts.size())
						{
							if(!selledProducts.get(i).getName().equals(product1.getName())
							||!selledProducts.get(i).getDate().equals(product1.getDate()))
							{
								j++;
							}
							i++;
						}
						if(j==selledProducts.size())
							try {
								dao.addProductToProductTable(product1);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						    //selledProducts.add(product1);
						i=0;
						j=0;
					}
					else 
					{
						try {
							dao.addProductToProductTable(product1);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//selledProducts.add(product1);
					}
					
					tableview1.getItems().clear();
					List<Product> selledProducts2=null;
					try {
						selledProducts2 = dao.bringProductTableContent();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					double selledTotal=0;
					for(Product sep: selledProducts2)
					{
						selledTotal+=sep.getTotal();
					}
					textfield3.setText(selledTotal+"");
					selledTotal=0;
					tableview1.getItems().addAll(selledProducts2);
					//tableview1.setItems(selledProducts);
				}
				
			};
			
			Button button2=new Button("Ürünü Siparişe Ekle");
			button2.setPrefSize(150, 20);
			button2.setLayoutX(360);
			button2.setLayoutY(100);
			button2.setOnAction(eh2);
			root.getChildren().add(button2);
			
			
			
			EventHandler eh3=new EventHandler()
			{

				@Override
				public void handle(Event arg0) {
					if(tableview.getSelectionModel().getSelectedItem()!=null)
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Uyarı");
						alert.setHeaderText("Dikkat");
						alert.setContentText("Bunu yaparsanız ürün siparişlerden silinip veritabanından da düşülecektir. Emin misiniz?");
						ButtonType result=alert.showAndWait().orElse(null);
						if(result.equals(ButtonType.OK)&&tableview.getSelectionModel().getSelectedItem()!=null)
						{
							Product sp=tableview.getSelectionModel().getSelectedItem();
							if(sp.getNumber()>1)
							{
								sp.setNumber(sp.getNumber()-1);
								sp.setTotal(sp.getNumber()*sp.getPrice());
							}else
							orderProducts.remove(sp);
							List<Product> selledProducts4=null;
							try {
								selledProducts4 = dao.bringProductTableContent();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							tableview.getItems().clear();
							tableview.getItems().addAll(orderProducts);
							double orderTotal=0;
							for(Product op: orderProducts)
							{
								orderTotal+=op.getTotal();
							}
							textfield2.setText(orderTotal+"");
							orderTotal=0;
							if(selledProducts4.size()>0)
							{
								int i=0;
								int j=0;
								while(i<selledProducts4.size())
								{
									if(selledProducts4.get(i).getName().equals(sp.getName())
									&&selledProducts4.get(i).getDate().equals(sp.getDate()))
									{
										try {
											dao.decreaseProductNumberByAlteringProductTable(selledProducts4.get(i).getName() 
												,selledProducts4.get(i).getDate(),selledProducts4.get(i).getNumber()
												,selledProducts4.get(i).getPrice());
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
//										selledProducts.get(i).setNumber(selledProducts.get(i).getNumber()+1);
//										selledProducts.get(i).setTotal(selledProducts.get(i).getNumber()
//												*selledProducts.get(i).getPrice());
									}
									i++;
								}
								i=0;
								while(i<selledProducts4.size())
								{
									if(!selledProducts4.get(i).getName().equals(sp.getName())
									||!selledProducts4.get(i).getDate().equals(sp.getDate()))
									{
										j++;
									}
									i++;
								}
								if(j==selledProducts4.size())
									try {
										dao.deleteFromProductTable(sp.getName(),sp.getDate());
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								    //selledProducts.add(product1);
								i=0;
								j=0;
							}
							else 
							{
								try {
									dao.deleteFromProductTable(sp.getName(),sp.getDate());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								//selledProducts.add(product1);
							}
							
							tableview1.getItems().clear();
							List<Product> selledProducts2=null;
							try {
								selledProducts2 = dao.bringProductTableContent();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							double selledTotal=0;
							for(Product sep: selledProducts2)
							{
								selledTotal+=sep.getTotal();
							}
							textfield3.setText(selledTotal+"");
							selledTotal=0;
							tableview1.getItems().addAll(selledProducts2);
							//tableview1.setItems(selledProducts);
						}
					}
					
					
				}
				
			};
			
			Button button3=new Button("Ürünü Siparişten Sil");
			button3.setPrefSize(170, 20);
			button3.setLayoutX(745);
			button3.setLayoutY(385);
			button3.setOnAction(eh3);
			root.getChildren().add(button3);
			
			EventHandler eh4=new EventHandler()
			{

				@Override
				public void handle(Event arg0) {
					Alert alert=new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Uyarı");
					alert.setHeaderText("Dikkat");
					alert.setContentText("Bunu yaparsanız sipariş sıfırlanacaktır. Emin misiniz?");
					ButtonType result=alert.showAndWait().orElse(null);
					if(result.equals(ButtonType.OK))
					{
						orderProducts.clear();
						tableview.getItems().clear();
						textfield4.setText("");
						textfield5.setText("");
						textarea6.setText("");
						double orderTotal=0;
						for(Product op: orderProducts)
						{
							orderTotal+=op.getTotal();
						}
						textfield2.setText(orderTotal+"");
						orderTotal=0;
					}
					
					
				}
				
			};
			
			Button button4=new Button("Siparişi Sıfırla");
			button4.setPrefSize(170, 20);
			button4.setLayoutX(745);
			button4.setLayoutY(415);
			button4.setOnAction(eh4);
			root.getChildren().add(button4);
			
			EventHandler eh7=new EventHandler()
			{

				@Override
				public void handle(Event arg0) {
					Alert alert=new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Uyarı");
					alert.setHeaderText("Dikkat");
					alert.setContentText("Bunu yaparsanız sipariş yazdırılacaktır. Emin misiniz?");
					ButtonType result=alert.showAndWait().orElse(null);
					if(result.equals(ButtonType.OK))
					{
						
					}
				
				}
				
			};
			
			Button button7=new Button("Siparişi Yazdır");
			button7.setPrefSize(170, 20);
			button7.setLayoutX(745);
			button7.setLayoutY(600);
			button7.setOnAction(eh7);
			root.getChildren().add(button7);
			
			EventHandler eh5=new EventHandler()
			{

				@Override
				public void handle(Event arg0) {
					Alert alert=new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Uyarı");
					alert.setHeaderText("Dikkat");
					alert.setContentText("Bunu yaparsanız veritabanı ve sipariş sıfırlanacaktır. Emin misiniz?");
					ButtonType result=alert.showAndWait().orElse(null);
					if(result.equals(ButtonType.OK))
					{
						try {
							dao.truncateProductTable();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						List<Product> selledProducts3=null;
						try {
							selledProducts3 = dao.bringProductTableContent();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						tableview.getItems().clear();
						orderProducts.clear();
						textfield4.setText("");
						textfield5.setText("");
						textarea6.setText("");
						double orderTotal=0;
						for(Product op: orderProducts)
						{
							orderTotal+=op.getTotal();
						}
						textfield2.setText(orderTotal+"");
						orderTotal=0;
						tableview1.getItems().clear();
						double selledTotal=0;
						for(Product sep: selledProducts3)
						{
							selledTotal+=sep.getTotal();
						}
						textfield3.setText(selledTotal+"");
						selledTotal=0;
						tableview1.getItems().addAll(selledProducts3);
					}
					
					
				}
				
			};
			
			Button button5=new Button("Veritabanını Sıfırla");
			button5.setPrefSize(180, 20);
			button5.setLayoutX(1135);
			button5.setLayoutY(490);
			button5.setOnAction(eh5);
			root.getChildren().add(button5);
			
			EventHandler eh6=new EventHandler()
			{

				@Override
				public void handle(Event arg0) {
					if(tableview1.getSelectionModel().getSelectedItem()!=null)
					{
						Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Uyarı");
						alert.setHeaderText("Dikkat");
						alert.setContentText("Bunu yaparsanız ürün veritabanından silinip siparişler ise sıfırlanacaktır. Emin misiniz?");
						ButtonType result=alert.showAndWait().orElse(null);
						if(result.equals(ButtonType.OK)&&tableview1.getSelectionModel().getSelectedItem()!=null)
						{
							Product sp0=tableview1.getSelectionModel().getSelectedItem();
							Product sp=null;
							try {
								sp = dao.bringProductFromProductTable(sp0.getName(), 
										sp0.getNumber(), sp0.getPrice(), sp0.getTotal(), sp0.getDate());
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(sp.getNumber()>1)
							{
								try {
									dao.decreaseProductNumberByAlteringProductTable(sp.getName(),
											sp.getDate(), sp.getNumber(), sp.getPrice());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								sp.setNumber(sp.getNumber()-1);
								sp.setTotal(sp.getNumber()*sp.getPrice());
								
									
								
							}else
							{
								try {
									dao.deleteFromProductTable(sp.getName(), sp.getDate());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							
							
							//List<Product> selledProducts4=dao.bringProductTableContent();
							
							tableview.getItems().clear();
							orderProducts.clear();
							textfield4.setText("");
							textfield5.setText("");
							textarea6.setText("");
							tableview.getItems().addAll(orderProducts);
							double orderTotal=0;
							for(Product op: orderProducts)
							{
								orderTotal+=op.getTotal();
							}
							textfield2.setText(orderTotal+"");
							orderTotal=0;
//						
							tableview1.getItems().clear();
							List<Product> selledProducts2=null;
							try {
								selledProducts2 = dao.bringProductTableContent();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							double selledTotal=0;
							for(Product sep: selledProducts2)
							{
								selledTotal+=sep.getTotal();
							}
							textfield3.setText(selledTotal+"");
							selledTotal=0;
							tableview1.getItems().addAll(selledProducts2);
							//tableview1.setItems(selledProducts);
						}
					}
					
				}
				
			};
			
			Button button6=new Button("Ürünü Veritabanından Sil");
			button6.setPrefSize(180, 20);
			button6.setLayoutX(1135);
			button6.setLayoutY(460);
			button6.setOnAction(eh6);
			root.getChildren().add(button6);
			
			Scene scene = new Scene(root,1350,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Image image=new Image("file:./donerciLogo.png");
			primaryStage.getIcons().add(image);
			primaryStage.setTitle("Dönerci Otomasyonu");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
