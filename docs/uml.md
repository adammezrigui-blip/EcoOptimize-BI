# UML Eco-Optimize BI

## Use Case Diagram
```plantuml
@startuml
actor "Responsable d’entreprise" as R

rectangle "Eco-Optimize BI" {
  usecase "Visualiser dashboard" as UC1
  usecase "Recevoir alertes" as UC2
}

R --> UC1
R --> UC2
@enduml
