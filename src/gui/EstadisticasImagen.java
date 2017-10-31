package gui;

import boofcv.alg.misc.ImageStatistics;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.Planar;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class EstadisticasImagen {
    public final int ROJO = 0;
    public final int VERDE = 1;
    public final int AZUL = 2;

    public final int[] Componentes = {ROJO, VERDE, AZUL};

    public int maximo[] = new int[3];
    public int minimo[] = new int[3];
    public int promedio[] = new int[3];
    
    public void calculaEstadisticas(BufferedImage imagen,
                                    Point esqSupIzda, 
                                    Point esqInfDcha) {
        
        // convertir BufferedImage a imagen formato BoofCV
        Planar<GrayU8> imagenColor = ConvertBufferedImage.convertFromPlanar(
                                        imagen,
                                        null, 
                                        true, 
                                        GrayU8.class);
        

        for (int c : this.Componentes) {
        this.maximo[c] = ImageStatistics.max(imagenColor.getBand(c).
            subimage(esqSupIzda.x, esqSupIzda.y, esqInfDcha.x, esqInfDcha.y));
        this.minimo[c] = ImageStatistics.min(imagenColor.getBand(c).
                subimage(esqSupIzda.x, esqSupIzda.y, esqInfDcha.x, esqInfDcha.y));
        this.promedio[c] = (int) ImageStatistics.mean(imagenColor.getBand(0).
                subimage(esqSupIzda.x, esqSupIzda.y, esqInfDcha.x, esqInfDcha.y));
        }
    }
}
