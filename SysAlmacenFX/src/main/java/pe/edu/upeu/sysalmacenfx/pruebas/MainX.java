package pe.edu.upeu.sysalmacenfx.pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;

import java.util.List;
import java.util.Scanner;

@Component
public class MainX {
    @Autowired
    CategoriaRepository repository;

    public void registro() {
        System.out.println("MAIN CATEGORIA");
        Categoria ca = new Categoria();
        ca.setNombre("Utiles escritorio");
        Categoria dd = repository.save(ca);
        System.out.println("Reporte:");
        System.out.println(dd.getIdCategoria() + "  " + dd.getNombre());
    }

    public void listar() {
        List<Categoria> datos = repository.findAll();
        System.out.println("ID\tNombre");
        for (Categoria ca : datos) {
            System.out.println(ca.getIdCategoria() + "\t" + ca.getNombre());
        }
    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese ID de la categoría a actualizar: ");
        Long id = Long.parseLong(sc.nextLine());

        Categoria ca = repository.findById(id).orElse(null);
        if (ca != null) {
            System.out.print("Ingrese nuevo nombre: ");
            String nuevoNombre = sc.nextLine();
            ca.setNombre(nuevoNombre);
            repository.save(ca);
            System.out.println("Categoría actualizada: " + ca.getIdCategoria() + "  " + ca.getNombre());
        } else {
            System.out.println("Categoría no encontrada con ID: " + id);
        }
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese ID de la categoría a eliminar: ");
        Long id = Long.parseLong(sc.nextLine());

        if (repository.existsById(id)) {
            repository.deleteById(id);
            System.out.println("Categoría eliminada con ID: " + id);
        } else {
            System.out.println("Categoría no encontrada con ID: " + id);
        }
    }

    public void menu() {
        int opc = 0;
        Scanner cs = new Scanner(System.in);
        String mensaje = "Seleccione una opción: \n1 = Crear\n2 = Listar\n3 = Actualizar\n4 = Eliminar\n0 = Salir";

        do {
            System.out.println(mensaje);
            opc = Integer.parseInt(cs.next());

            switch (opc) {
                case 1:
                    registro();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opc != 0);
    }
}
