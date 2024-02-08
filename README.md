# Graphql-crud
Go to localhost:8080/graphiql

## Example

1. for fetching all student :
     ```graphql
     query {
      allStudent{
        id
        name
       // other fields
      } 
    }
    ```

2. Fetch student with id :
   ```graphql
   query {
     findOne(id: 1){
        id
        name
        email
       // other field
      }
    }
   ```
