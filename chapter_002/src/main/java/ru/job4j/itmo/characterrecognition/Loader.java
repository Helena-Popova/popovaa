package ru.job4j.itmo.characterrecognition;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import ru.job4j.itmo.characterrecognition.exceptions.*;

public class Loader {
    private final String trainImages = "C:\\projects\\libMNIST\\train-images.idx3-ubyte";
    private final String trainLabels = "C:\\projects\\libMNIST\\train-labels.idx1-ubyte";
    static String testFile = "C:\\projects\\libMNIST\\t10k-images.idx3-ubyte";
    static String testLabel = "C:\\projects\\libMNIST\\t10k-labels.idx1-ubyte";
    private List<DataJPG> mnist = new ArrayList<>();


    /**
     * c этого метода все начинается. считывает байты картинок в ArrayList<int[]>
     * @param trainImages
     * @return возвращает лист с байтами картинок
     * @throws IOException что то тоже про файл
     * @throws FileExceprion не тот файл
     */
    public ArrayList<int[]>  getColorsMatrix(String trainImages) throws IOException, FileExceprion {
        ByteBuffer bb = loadFile(trainImages);
        checkExceprion(2051, bb.getInt());
        int numberItems  = bb.getInt();
        int numberRows = bb.getInt();
        int numberColumns = bb.getInt();

        ArrayList<int[]> images = new ArrayList<>();

        for (int i = 0; i < numberItems; i++) {
            images.add(readImage(numberRows, numberColumns, bb));
        }
        return images;
    }

    private static int[] readImage(int numRows, int numCols, ByteBuffer bb) {
        int[] image = new int[numRows * numCols];
        for (int index = 0; index < numRows * numCols; index++) {
            image[index] = bb.get() & 0xFF;
        }
        return image;
    }

    /**
     * считывает значащие лейблы к картинкам
     * @param trainLabels название файла
     * @return возвращает массив соответственно значащих лейблов к картинкам
     * @throws IOException
     */
    public int[] getLabel(String trainLabels) throws IOException {

        ByteBuffer bb = loadFile(trainLabels);
        checkExceprion(2049, bb.getInt());
        int numLabels = bb.getInt();
        int[] digits = new int[numLabels];

        for (int i = 0; i < numLabels; ++i) {
            digits[i] = bb.get() & 0xFF;
        }
        return  digits;
    }

    public void checkExceprion(int exeption, int value) {
        if (exeption != value) {
            switch (exeption) {
                case 2049:
                    throw new FileExceprion("This is not a label file.");
                case 2051:
                    throw new FileExceprion("This is not an image file.");
                default:
                    throw new FileExceprion("Unknown exception");
            }
        }
    }


    public static ByteBuffer loadFile(String fileName) {
        try {
            RandomAccessFile f = new RandomAccessFile(fileName, "r");
            FileChannel chan = f.getChannel();
            long fileSize = chan.size();
            ByteBuffer bb = ByteBuffer.allocate((int) fileSize);
            chan.read(bb);
            bb.flip();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            for (int i = 0; i < fileSize; i++) {
                baos.write(bb.get());
            }
            chan.close();
            f.close();
            return ByteBuffer.wrap(baos.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<DataJPG>  getMap() throws IOException, FileExceprion {
        List<int[]> color = getColorsMatrix(trainImages);
        int[] label = getLabel(trainLabels);
        if (color.size() != label.length) {
            throw new FileExceprion("Считано неверно");
        } else {
            for (int i = 0; i < label.length; i++) {
                DataJPG dataJPG = new DataJPG(label[i], color.get(i));
                this.mnist.add(dataJPG);
            }
        }
        return this.mnist;
    }

    public DataJPG  getNumberOfRecognition(int index) throws IOException, FileExceprion {
        DataJPG dataJPG = new DataJPG(-1, new int[]{-1});
        List<int[]> color = getColorsMatrix(testFile);
        int[] label = getLabel(testLabel);
        if (color.size() != label.length) {
            throw new FileExceprion("Считано неверно");
        } else {
            if (index < label.length) {
                dataJPG = new DataJPG(label[index], color.get(index));
            } else {
                throw new FileExceprion("В файле нет такой картинки");
            }
        }
        return dataJPG;
    }
}
