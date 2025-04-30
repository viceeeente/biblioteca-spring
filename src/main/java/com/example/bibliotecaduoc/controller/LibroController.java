package com.example.bibliotecaduoc.controller;
import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {
    @Autowired
    private LibroService libroService;


    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro (@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    @PutMapping("{id}")
    public Libro actualizarLibro (@PathVariable int id, @RequestBody Libro libro){
        // el id lo usaremos mas delante
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibrosV2(){
        return libroService.totalLibrosV2();
    }

    @GetMapping("/isbn/{isbn}")
    public Libro  buscarIsbn (@PathVariable String isbn){
        return libroService.getLibroIsbn(isbn);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Libro> agruparFechas(@PathVariable int fecha){
        return libroService.agruparFechas(fecha);
    }

    @GetMapping("/autor/{autor}")
    public List<Libro> agruparAutor(@PathVariable String autor){
        return libroService.agruparAutor(autor);
    }

    @GetMapping("/antiguo")
    public Libro libroAntiguo(@PathVariable String fecha){
        return libroService.getLibroAntiguo(fecha);
    }


}
