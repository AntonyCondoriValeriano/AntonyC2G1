package com.pasteleria.pasteleria.control;

import com.pasteleria.pasteleria.componente.ColumnInfo;
import com.pasteleria.pasteleria.componente.TableViewHelper;
import com.pasteleria.pasteleria.componente.Toast;
import com.pasteleria.pasteleria.dto.ComboBoxOption;
import com.pasteleria.pasteleria.modelo.Categoria;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class CategoriaController {
    @FXML
    TextField txtNombreProducto, txtPUnit,
            txtPUnitOld, txtUtilidad, txtStock, txtStockOld,
            txtFiltroDato;
    @FXML
    ComboBox<ComboBoxOption> cbxMarca;
    @FXML
    ComboBox<ComboBoxOption> cbxCategoria;
    @FXML
    ComboBox<ComboBoxOption> cbxUnidMedida;
    @FXML
    private TableView<Categoria> tableView;
    @FXML
    Label lbnMsg;
    @FXML
    private AnchorPane miContenedor;
    Stage stage;


    private Validator validator;
    ObservableList<Categoria> listarCategoria;
    Categoria formulario;
    Long idCategoriaCE=0L;

    public void initialize() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), event -> {
            stage = (Stage) miContenedor.getScene().getWindow();
            if (stage != null) {
                System.out.println("El título del stage es: " + stage.getTitle());
            } else {
                System.out.println("Stage aún no disponible.");
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();


        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        // Crear instancia de la clase genérica TableViewHelper
        TableViewHelper<Categoria> tableViewHelper = new TableViewHelper<>();
        LinkedHashMap<String, ColumnInfo> columns = new LinkedHashMap<>();
        columns.put("ID Pro.", new ColumnInfo("idCategoria", 60.0)); // Columna visible "Columna 1" mapea al campo "campo1"
        columns.put("Nombre Producto", new ColumnInfo("nombre", 200.0)); // Columna visible "Columna 2" mapea al campo "campo2"


        Consumer<Categoria> updateAction = (Categoria categoria) -> {
            System.out.println("Actualizar: " + categoria);
            editForm(categoria);
        };
        Consumer<Categoria> deleteAction = (Categoria categoria) -> {System.out.println("Actualizar: " + categoria);
            double with=stage.getWidth()/1.5;
            double h=stage.getHeight()/2;
            Toast.showToast(stage, "Se eliminó correctamente!!", 2000, with, h);
            listar();
        };

        tableViewHelper.addColumnsInOrderWithSize(tableView, columns,updateAction, deleteAction );

        tableView.setTableMenuButtonVisible(true);
        listar();

    }

    public void listar(){
        try {
            tableView.getItems().clear();
            listarCategoria = FXCollections.observableArrayList(ps.list());
            tableView.getItems().addAll(listarCategoria);
            // Agregar un listener al campo de texto txtFiltroDato para filtrar los Categoria
            txtFiltroDato.textProperty().addListener((observable, oldValue, newValue) -> {
                filtrarProductos(newValue);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void limpiarError(){
        txtNombreCategoria.getStyleClass().remove("text-field-error");
    }

    public void clearForm(){
        txtNombreCategoria.setText("");

        idCategoriaCE=0L;
        limpiarError();
    }

    @FXML
    public void cancelarAccion(){
        clearForm();
        limpiarError();
    }

    void validarCampos(List<ConstraintViolation<Categoria>> violacionesOrdenadasPorPropiedad){
// Crear un LinkedHashMap para ordenar las violaciones
        LinkedHashMap<String, String> erroresOrdenados = new LinkedHashMap<>();
// Mostrar el primer mensaje de error
        for (ConstraintViolation<Categoria> violacion : violacionesOrdenadasPorPropiedad) {
            String campo = violacion.getPropertyPath().toString();
            if(campo.equals("nombre")) {
                erroresOrdenados.put("nombre", violacion.getMessage());
                txtNombreCategoria.getStyleClass().add("text-field-error");
            }
        }
        // Mostrar el primer error en el orden deseado
        Map.Entry<String, String> primerError = erroresOrdenados.entrySet().iterator().next();
        lbnMsg.setText(primerError.getValue()); // Mostrar el mensaje del primer error
        lbnMsg.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
    }

    @FXML
    public void validarFormulario() {
        formulario = new Categoria();
        formulario.setNombre(txtNombreCategoria.getText());

        Set<ConstraintViolation<Categoria>> violaciones = validator.validate(formulario);
// Si prefieres ordenarlo por el nombre de la propiedad que violó la restricción, podrías usar:
        List<ConstraintViolation<Categoria>> violacionesOrdenadasPorPropiedad = violaciones.stream()
                .sorted((v1, v2) -> v1.getPropertyPath().toString().compareTo(v2.getPropertyPath().toString()))
                .collect(Collectors.toList());
        if (violacionesOrdenadasPorPropiedad.isEmpty()) {
// Los datos son válidos
            lbnMsg.setText("Formulario válido");
            lbnMsg.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");
            limpiarError();
            double with=stage.getWidth()/1.5;
            double h=stage.getHeight()/2;
            if(idCategoriaCE!=0L && idCategoriaCE>0L){
                formulario.setIdCategoria(idCategoriaCE);
                Toast.showToast(stage, "Se actualizó correctamente!!", 2000, with, h);
                clearForm();
            }else{
                Toast.showToast(stage, "Se guardo correctamente!!", 2000, with, h);
                clearForm();
            }
            listar();
        } else {
            validarCampos(violacionesOrdenadasPorPropiedad);
        }
    }

    private void filtrarCategorias(String filtro) {
        if (filtro == null || filtro.isEmpty()) {
            tableView.getItems().clear();
            tableView.getItems().addAll(listarCategoria);
        } else {

            String lowerCaseFilter = filtro.toLowerCase();
            List<Categoria> categoriaFiltrados = listarCategoria.stream()
                    .filter(categoria -> {

                        if (categoria.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                            return true;
                        }
                        return false;
                    })
                    .collect(Collectors.toList());
            tableView.getItems().clear();
            tableView.getItems().addAll(categoriasFiltrados);
        }
    }

    public void editForm(Categoria categoria){
        txtNombreCategoria.setText(categoria.getNombre());

        idCategoriaCE=categoria.getIdCategoria();
        limpiarError();
    }

}
