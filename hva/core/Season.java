package hva.core;

public enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

    public Season skipSeason() throws IllegalStateException {
        switch (this) {
            case SPRING:
                return SUMMER;
            case SUMMER:
                return AUTUMN;
            case AUTUMN:
                return WINTER;
            case WINTER:
                return SPRING;
            default: throw new IllegalStateException("Estação inválida: " + this);
        }

    }
}
