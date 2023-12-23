package models;
import java.util.ArrayList;

public class Shape {
    private ArrayList<Point> points;

    public Shape() {
        this.points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public double calculatePerimeter() {
        if (points.isEmpty()) {
            // No points to calculate perimeter
            return 0.0;
        }

        double perimeter = 0.0;
        for (int i = 0; i < points.size(); i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get((i + 1) % points.size()); // Use modulo to handle the last point
            perimeter += currentPoint.distance(nextPoint);
        }

        return perimeter;
    }

    public double getLongestDistance() {
        int numberOfPoints = points.size();
        if (numberOfPoints < 2) {
            // Not enough points
            return 0.0;
        }

        double longestDistance = points.get(numberOfPoints - 1).distance(points.get(0));
        for (int i = 0; i < numberOfPoints - 1; i++) {
            double distance = points.get(i).distance(points.get(i + 1));
            longestDistance = Math.max(longestDistance, distance);
        }

        return longestDistance;
    }

    public double getAverageDistance() {
        int numberOfPoints = points.size();
        if (numberOfPoints == 0) {
            // Avoid division by zero
            return 0.0;
        }

        return calculatePerimeter() / numberOfPoints;
    }
}



