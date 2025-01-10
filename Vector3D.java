/**
 * A vector in R^3
 */
public class Vector3D {
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    /**
     * @return the string representation of the vector
     */
    public String toString() {
        return "(" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ", " + String.format("%.2f", z) + ")";
    }

    /**
     * @return the magnitude of the vector
     */
    public double getMagnitude() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    /**
     * @return the normalized version of the vector
     * @throws IllegalStateException if the vector magnitude is zero
     */
    public Vector3D normalize() {
        double magnitude = getMagnitude();
        if (magnitude == 0) throw new IllegalStateException("Vector magnitude is zero!");
        else return new Vector3D(x / magnitude, y / magnitude, z / magnitude);
    }

    /**
     * @param other the other vector
     * @return the sum of the two vectors
     */
    public Vector3D add(Vector3D other) {
        return new Vector3D(this.x + other.getX(), this.y + other.getY(), this.z + other.getZ());
    }

    /**
     * @param scalar the number to multiply the vector with
     * @return the resulting vector after scalar multiplication is donee
     */
    public Vector3D multiply(double scalar) {
        return new Vector3D(scalar * this.x, scalar * this.y, scalar * this.z);
    }

    /**
     * @param other the other vector to perform the dot product on
     * @return the dot product of the two vectors
     */
    public double dotProduct(Vector3D other) {
        return (this.x * other.getX()) + (this.y * other.getY()) + (this.z * other.getZ());
    }

    /**
     * @param other the other vector
     * @return the smaller of the two angles between two vectors
     */
    public double angleBetween(Vector3D other) {
        return Math.acos(this.dotProduct(other) / (this.getMagnitude() * other.getMagnitude()));
    }

    /**
     * @param other the other vector
     * @return the cross product of the two vectors
     */
    public Vector3D crossProduct(Vector3D other) {
        double xComponent = (this.y * other.getZ()) - (this.z * other.getY());
        double yComponent = (this.z * other.getX()) - (this.x * other.getZ());
        double zComponent = (this.x * other.getY()) - (this.y * other.getX());
        return new Vector3D(xComponent, yComponent, zComponent);
    }
}