module com.example.minipayroll2_4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.minipayroll2_4 to javafx.fxml;
    exports com.example.minipayroll2_4;
}