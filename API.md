# Practica 1 Tecnologias

## Documentación API

1. Listado de Posts

    ` method: ` **GET**

    ` url: ` **localhost:8080/api/posts/**
    
    ` json devuelto: `

    ```json
    [
        {
            "1": {
                "title": "nuevo post"
            }
        },
        {
            "2": {
                "title": "nuevo post"
            }
        },
        {
            "3": {
                "title": "nuevo post"
            }
        }
    ]
    ```

2. Ver un Post

    ` method: ` **GET**

    ` url: ` **localhost:8080/api/posts/{postId}/**
    
    ` json devuelto: `

    ```json
    {
        "title": "nuevo post",
        "content": "prueba de nuevo post con contenido",
        "comments": [
            {
                "1": {
                    "userName": "Neo",
                    "comment": "prueba de añadir comentario nuevo"
                }
            },
            {
                "2": {
                    "userName": "Neo",
                    "comment": "prueba de añadir comentario nuevo"
                }
            }
        ]
    }
    ```

3. Añadir un Post

    ` method: ` **POST**

    ` url: ` **localhost:8080/api/posts/**
    
    ` json de entrada: `

    ```json
    {
        "title": "nuevo post",
        "content": "prueba de nuevo post con contenido"
    }
    ```

    ` salida: ` Id del Post creado
    
    ```json
    3
    ```

4. Añadir un Comentario

    ` method: ` **POST**

    ` url: ` **localhost:8080/api/posts/{postId}/coments/**
    
    ` json de entrada: `

    ```json
    {
        "userName" : "Neo",
        "comment" : "prueba de añadir comentario nuevo"
    }
    ```
    
    ` salida: ` Id del Comentario creado
    
    ```json
    2
    ```

5. Borrar un Comentario

    ` method: ` **DELETE**

    ` url: ` **localhost:8080/api/posts/{postId}/coments/{comentId}/**
    
    ` json devuelto: ` Comentario borrado
    
    ```json
    {
        "userName": "Neo",
        "comment": "prueba de añadir comentario nuevo"
    }
    ```    