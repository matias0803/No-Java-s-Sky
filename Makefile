
SRC = NoJavaSky.java
OUT_DIR = clases
OUT = NoJavaSky


all: run

$(OUT_DIR)/$(OUT).class: $(SRC)
	mkdir -p $(OUT_DIR)   
	javac -d $(OUT_DIR) $(SRC)


run: $(OUT_DIR)/$(OUT).class
	java -cp $(OUT_DIR) $(OUT)


clean:
	rm -rf $(OUT_DIR)
