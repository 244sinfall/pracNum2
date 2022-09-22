// Я бы все же создал "мебель" как абстрактный с парочкой реализаций, но буду делать по заданию :)

public class Furniture {
    private FurnitureType _type;
    private String _material;
    private String _name;
    private float _squareArea;
    private int _price;
    public Furniture() {
        this._type = FurnitureType.UNSPECIFIED;
        this._material = "разные";
        this._name = "Мебель-сюрприз";
        this._price = 500;
        this._squareArea = 1;
    }
    public Furniture(FurnitureType type, String material, String name, int price, float squareArea) {
        this._type = type;
        this._material = material;
        this._name = name;
        this._price = price;
        this._squareArea = squareArea;
    }
    public FurnitureType getType() {
        return this._type;
    }
    public String getMaterial() {
        return this._material;
    }
    public String getName() {
        return this._name;
    }
    public float getSquareArea() {
        return this._squareArea;
    }
    public int getPrice() {
        return this._price;
    }
    /**
     * Устанавливает существующий тип для мебили. См {@link FurnitureType}
     * @param type новый тип
     */
    public void setType(FurnitureType type) {
        this._type = type;
    }

    /**
     * Устанавливает новый материал для мебили.
     * @param newMaterial новый материал, не может быть пустой строкой
     */
    public void setMaterial(String newMaterial) {
        if(newMaterial.length() == 0) {
            System.out.println("Вы не ввели значение");
            return;
        }
        this._material = newMaterial;
    }

    /**
     * Устанавливает новое имя для мебели
     * @param newName новое имя, не может быть пустым
     */
    public void setName(String newName) {
        if(newName.length() == 0) {
            System.out.println("Вы не ввели значение");
            return;
        }
        this._name = newName;
    }

    /**
     * Устанавливает площадь мебели
     * @param newSquareArea новая площадь, не может быть меньше или равна 0. Не может быть больше максимального числа типа Float
     */
    public void setSquareArea(float newSquareArea) {
        if(newSquareArea <= 0 || newSquareArea > Float.MAX_VALUE) {
            System.out.println("Недопустимое значение");
            return;
        }
        this._squareArea = newSquareArea;
    }

    /**
     * Устанавливает цену мебели
     * @param newPrice новая цена, не может быть меньше или равна 0
     */
    public void setPrice(int newPrice) {
        if(newPrice <= 0) {
            System.out.println("Недопустимое значение");
            return;
        }
        this._price = newPrice;
    }

    /**
     * Метод считает стоимость доставки мебели исходя из ее характеристик и предоставленных данных
     * @param distanceKm дистанция для доставки, в километрах
     * @param unloadRequired нужна ли разгрузка
     * @return Цена доставки
     */
    public float getDeliveryPrice(float distanceKm, boolean unloadRequired) {
        int baseDeliveryPrice = this._price / 50;
        float areaModifier = this._squareArea * 100;
        float distanceModifier = baseDeliveryPrice * distanceKm;
        float deliveryOnly = (float) baseDeliveryPrice + areaModifier + distanceModifier;
        return unloadRequired ? deliveryOnly + 500 : deliveryOnly;
    }
}
