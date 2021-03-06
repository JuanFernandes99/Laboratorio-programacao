import { useEffect, useState } from "react";
import * as React from "react";
import Grid from "@mui/material/Grid";
import FormControl from "@mui/material/FormControl";
import RadioGroup from "@mui/material/RadioGroup";
import Paper from "@mui/material/Paper";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActionArea } from "@mui/material";
import { useNavigate } from "react-router-dom";

export function Getempresa(props) {
  const API_URL = "http://localhost:8080";
  const navigate = useNavigate();
  const [listaEmpresa, setListasEmpresa] = useState([]);
  useEffect(() => {
    console.log("ola");
    GetEmpresas();
  }, []);

  function GetEmpresas() {
    fetch(API_URL + "/getAllEmpresas", {
      mode: "cors",
      method: "GET",
      headers: {
        "Content-type": "application/json",
      },
    })
      .then((response) => {
        console.log(response);

        if (response.status !== 200) {
          throw new Error("Ocorreu um erro, nenhum Autor disponível");
        }

        return response.json();
      })
      .then((parsedResponse) => {
        console.log(parsedResponse);
        setListasEmpresa(parsedResponse);
        console.log(parsedResponse);
      })
      .catch((error) => {
        alert(error);
      });
  }

  function DeleteEmpresa(element) {
    fetch(API_URL + "/deleteEmpresa/" + element, {
      method: "Delete",
      headers: {
        "Content-type": "application/json",
      },
    })
      .then((response) => {
        console.log(response);

        if (response.status !== 200) {
          throw new Error("Ocorreu um erro, nenhum Autor disponível");
        }

        return response.json();
      })
      .then((parsedResponse) => {
        console.log(parsedResponse);
        alert(parsedResponse.message);
        GetEmpresas();
      })
      .catch((error) => {
        alert(error);
      });
  }

  return listaEmpresa.length !== 0 ? (
    <>
      <Grid item xs={12}>
        <Paper sx={{ p: 2 }}>
          <Grid container>
            <Grid item>
              <FormControl component="fieldset">
                <RadioGroup titulo="spacing" aria-label="spacing" row>
                  {listaEmpresa.map((element) => (
                    <>
                      <Card
                        key={element.id}
                        sx={{ margin: 1.5, maxWidth: 180, maxHeight: 340 }}
                      >
                        <CardActionArea
                          onClick={() => {
                            props.setInfoEmpresa(element);
                            navigate("/empresaID/" + element.id);
                          }}
                        >
                          <CardMedia
                            component="img"
                            height="180"
                            image={element.imagem}
                            alt="livro"
                          />

                          <CardContent>
                            <Typography
                              gutterBottom
                              variant="h6"
                              component="div"
                            >
                              {element.nome}
                            </Typography>
                          </CardContent>
                        </CardActionArea>
                        <Button
                          onClick={() => {
                            DeleteEmpresa(element.id);
                            console.log(element.id);
                          }}
                        >
                          Remove
                        </Button>
                      </Card>
                    </>
                  ))}
                </RadioGroup>
              </FormControl>
            </Grid>
          </Grid>
        </Paper>
      </Grid>
    </>
  ) : (
    <p>Não existem empresas</p>
  );
}
