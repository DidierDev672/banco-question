package org.acme.domain.valueobjects;

public class DifficultyLevel {
    private final int level;

    public DifficultyLevel(int level) {
        if (level < 1 || level > 10) {
            throw new IllegalArgumentException("El nivel de dificultad debe estar entre 1 y 10.");
        }
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DifficultyLevel that = (DifficultyLevel) obj;
        return level == that.level;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(level);
    }
}
