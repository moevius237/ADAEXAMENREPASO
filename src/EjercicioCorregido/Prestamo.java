package EjercicioCorregido;

import java.time.LocalDateTime;

public class Prestamo {
        private String  uauario;
        private LocalDateTime fechaPrestamo;
        private LocalDateTime fechaDevolucion;
        private int ejemplarID;

        public Prestamo(String uauario, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion, int ejemplarID) {
            this.uauario = uauario;
            this.fechaPrestamo = fechaPrestamo;
            this.fechaDevolucion = fechaDevolucion;
            this.ejemplarID = ejemplarID;
        }

        public String getUauario() {
            return uauario;
        }

        public void setUauario(String uauario) {
            this.uauario = uauario;
        }

        public LocalDateTime getFechaPrestamo() {
            return fechaPrestamo;
        }

        public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
            this.fechaPrestamo = fechaPrestamo;
        }

        public int getEjemplarID() {
            return ejemplarID;
        }

        public void setEjemplarID(int ejemplarID) {
            this.ejemplarID = ejemplarID;
        }

        public LocalDateTime getFechaDevolucion() {
            return fechaDevolucion;
        }

        public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
            this.fechaDevolucion = fechaDevolucion;
        }
    }
