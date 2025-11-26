FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . .
RUN javac CalculatorApp.java
CMD ["java", "CalculatorApp"]