module se.kth.labb3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens se.kth.shapes to javafx.fxml;
    exports se.kth.shapes;
    opens se.kth to javafx.fxml;
    exports se.kth;
}
