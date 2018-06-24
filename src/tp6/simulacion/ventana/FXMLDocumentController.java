/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.simulacion.ventana;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tp6.simulacion.Class.Eventos.Simulacion.GestorSimulacion;
import tp6.simulacion.Class.Eventos.Simulacion.VectorEstadoView;

/**
 * FXML Controller class
 *
 * @author nicolastomassi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<VectorEstadoView> tableVectorEstado;
    @FXML
    private TableColumn<VectorEstadoView, String> relojColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> rndLlegadaColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> tiempoLlegadaColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> proximaLlegadaColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> rndCargaColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> cargaColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> rndInterrupcionColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> porcentajeInterrupcionColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> porcentajeActualInterrupcionColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> proximaInterrupcionColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> inicioCargaT1Column;
    @FXML
    private TableColumn<VectorEstadoView, String> finCargaT1Column;
    @FXML
    private TableColumn<VectorEstadoView, String> inicioCargaT2Column;
    @FXML
    private TableColumn<VectorEstadoView, String> finCargaT2Column;
    @FXML
    private TableColumn<VectorEstadoView, String> inicioCargaT3Column;
    @FXML
    private TableColumn<VectorEstadoView, String> finCargaT3Column;
    @FXML
    private TableColumn<VectorEstadoView, String> finDescargaT1Column;
    @FXML
    private TableColumn<VectorEstadoView, String> finDescargaT2Column;
    @FXML
    private TableColumn<VectorEstadoView, String> finDescargaT3Column;
    @FXML
    private TableColumn<VectorEstadoView, String> colaColumn;
    @FXML
    private TableColumn<VectorEstadoView, String> estadoT1Column;
    @FXML
    private TableColumn<VectorEstadoView, String> capacidadLibreT1Column;
    @FXML
    private TableColumn<VectorEstadoView, String> estadoT2Column;
    @FXML
    private TableColumn<VectorEstadoView, String> capacidadLibreT2Column;
    @FXML
    private TableColumn<VectorEstadoView, String> estadoT3Column;
    @FXML
    private TableColumn<VectorEstadoView, String> capacidadLibreT3Column;
    @FXML
    private TableColumn<VectorEstadoView, String> estadoB1Column;
    @FXML
    private TableColumn<VectorEstadoView, String> cargaActualB1Column;
    @FXML
    private TableColumn<VectorEstadoView, String> estadoB2Column;
    @FXML
    private TableColumn<VectorEstadoView, String> cargaActualB2Column;
    @FXML
    private TableColumn<VectorEstadoView, String> estadoB3Column;
    @FXML
    private TableColumn<VectorEstadoView, String> cargaActualB3Column;
    @FXML
    private TextField txtHorasSimulacion;
    @FXML
    private Button btnSimular;
    @FXML
    private TextField txtHoraDesde;
    @FXML
    private TextField txtHoraHasta;

    private double horasSimulacion, horaHasta, horaDesde;
    private GestorSimulacion simulador;
    private ObservableList<VectorEstadoView> estados;
    @FXML
    private TableColumn<VectorEstadoView, String> finInterrupcionColumn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.relojColumn.setCellValueFactory(new PropertyValueFactory("reloj"));
        this.rndLlegadaColumn.setCellValueFactory(new PropertyValueFactory<>("rndLlegadaBuque"));
        this.tiempoLlegadaColumn.setCellValueFactory(new PropertyValueFactory("tiempoLlegadaBuque"));
        this.proximaLlegadaColumn.setCellValueFactory(new PropertyValueFactory("proximaLlegada"));
        this.rndCargaColumn.setCellValueFactory(new PropertyValueFactory("rndCarga"));
        this.cargaColumn.setCellValueFactory(new PropertyValueFactory("cargaBuque"));
        this.inicioCargaT1Column.setCellValueFactory(new PropertyValueFactory("tiempoInicioCargaT1"));
        this.inicioCargaT2Column.setCellValueFactory(new PropertyValueFactory("tiempoInicioCargaT2"));
        this.inicioCargaT3Column.setCellValueFactory(new PropertyValueFactory("tiempoInicioCargaT3"));
        this.finCargaT1Column.setCellValueFactory(new PropertyValueFactory("tiempoFinCargaT1"));
        this.finCargaT2Column.setCellValueFactory(new PropertyValueFactory("tiempoFinCargaT2"));
        this.finCargaT3Column.setCellValueFactory(new PropertyValueFactory("tiempoFinCargaT3"));
        this.finDescargaT1Column.setCellValueFactory(new PropertyValueFactory("tiempoFinDescargaT1"));
        this.finDescargaT2Column.setCellValueFactory(new PropertyValueFactory("tiempoFinDescargaT2"));
        this.finDescargaT3Column.setCellValueFactory(new PropertyValueFactory("tiempoFinDescargaT3"));
        this.capacidadLibreT1Column.setCellValueFactory(new PropertyValueFactory("capacidadLibreT1"));
        this.capacidadLibreT2Column.setCellValueFactory(new PropertyValueFactory("capacidadLibreT2"));
        this.capacidadLibreT3Column.setCellValueFactory(new PropertyValueFactory("capacidadLibreT3"));
        this.estadoT1Column.setCellValueFactory(new PropertyValueFactory("estadoT1"));
        this.estadoT2Column.setCellValueFactory(new PropertyValueFactory("estadoT2"));
        this.estadoT3Column.setCellValueFactory(new PropertyValueFactory("estadoT3"));
        this.cargaActualB1Column.setCellValueFactory(new PropertyValueFactory("cargaActualB1"));
        this.cargaActualB2Column.setCellValueFactory(new PropertyValueFactory("cargaActualB2"));
        this.cargaActualB3Column.setCellValueFactory(new PropertyValueFactory("cargaActualB3"));
        this.estadoB1Column.setCellValueFactory(new PropertyValueFactory("estadoB1"));
        this.estadoB2Column.setCellValueFactory(new PropertyValueFactory("estadoB2"));
        this.estadoB3Column.setCellValueFactory(new PropertyValueFactory("estadoB3"));
        this.colaColumn.setCellValueFactory(new PropertyValueFactory("cola"));
        this.rndInterrupcionColumn.setCellValueFactory(new PropertyValueFactory("rndInterrupcion"));
        this.porcentajeInterrupcionColumn.setCellValueFactory(new PropertyValueFactory("porcentajeInterrupcion"));
        this.porcentajeActualInterrupcionColumn.setCellValueFactory(new PropertyValueFactory("porcentajeActual"));
        this.proximaInterrupcionColumn.setCellValueFactory(new PropertyValueFactory("inicioInterrupcion"));
        this.finInterrupcionColumn.setCellValueFactory(new PropertyValueFactory("finInterrupcion"));
        
    }    

    
    private boolean validarDatos(){
        
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("ERROR");
        try{
            horasSimulacion = Double.parseDouble(txtHorasSimulacion.textProperty().get());
            horaDesde = Double.parseDouble(txtHoraDesde.textProperty().get());
            horaHasta = Double.parseDouble(txtHoraHasta.textProperty().get());
        }
        catch (NumberFormatException e){
            dialog.setHeaderText("Debe cargar números");
            dialog.showAndWait();
            return false;
        }
        
        if (horasSimulacion < 0 || horaDesde < 0 || horaHasta < 0) {
            dialog.setHeaderText("Los números deben ser superiores a 0");
            dialog.showAndWait();
            return false;
        }
        
        if (horaDesde >= horaHasta) {
            dialog.setHeaderText("Intervalo invalido");
            dialog.showAndWait();
            return false;
        }
        
        
        
        return true;
    }

    @FXML
    private void clickBtnSimular(MouseEvent event) {
        
        if (validarDatos()) {
           simulador = new GestorSimulacion(this.horaDesde, this.horaHasta, this.horasSimulacion);
           this.estados = simulador.simular();
           
           tableVectorEstado.setItems(estados);
           Alert dialog = new Alert(Alert.AlertType.INFORMATION);
           dialog.setTitle("Éxito");
           dialog.setHeaderText("Simulacion");
           dialog.showAndWait();
        }
                
        
    }
}
