import { Typography } from "@mui/material";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Card from "@mui/material/Card";
import CardMedia from "@mui/material/CardMedia";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import CardContent from "@mui/material/CardContent";
import FormControl from "@mui/material/FormControl";
import RadioGroup from "@mui/material/RadioGroup";
import { CardActionArea } from "@mui/material";

export function EmpresaSelecionada(props) {
  const API_URL = "http://localhost:8080";
  const [funcionarios, setListaFuncionarios] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    getFuncionarios();
  }, []);

  function getFuncionarios() {
    fetch(API_URL + "/getPessoasByEmpresa/" + props.infoEmpresa.id, {
      // mode: "cors",
      headers: {
        "Content-type": "application/json",
      },
    })
      .then((response) => {
        // Validar se o pedido foi feito com sucesso. Pedidos são feitos com sucesso normalmente quando o status é entre 200 e 299
        if (response.status !== 200) {
          throw new Error("There was an error finding pessoas");
        }

        return response.json();
      })
      .then((parsedResponse) => {
        setListaFuncionarios(parsedResponse);
        console.log(funcionarios);
        console.log(parsedResponse);
      })
      .catch((error) => {
        alert(error);
      });
  }
  return props.infoEmpresa !== {} ? (
    <div>
      <Grid sx={{ flexGrow: 1, marginTop: 5 }} container spacing={2}>
        <Grid container>
          <Grid container justifyContent="center">
            <Card sx={{ maxWidth: 400, margin: 1 }}>
              <CardMedia
                component="img"
                height="250"
                image={props.infoEmpresa.imagem}
                alt="clienteIMG"
              />
              <br></br>
              <p> Informações gerais</p>
              <p>{"Nome: " + props.infoEmpresa.nome}</p>
              <p>{"morada: " + props.infoEmpresa.morada}</p>
            </Card>

            <Card sx={{ width: 600, margin: 1 }}>
              <CardActionArea>
                <CardMedia />
              </CardActionArea>
              <p id="textoSobre"> - Sobre o empresa -</p>
              <p>
                {"numeroFuncionariosAtual: " +
                  props.infoEmpresa.numeroFuncionariosAtual}
              </p>
            </Card>
          </Grid>
        </Grid>
      </Grid>
      <p id="textoSobre"> funcionarios</p>
      <Grid item xs={12}>
        <Paper sx={{ p: 2 }}>
          <Grid container>
            <Grid item>
              <FormControl component="fieldset">
                <RadioGroup titulo="spacing" aria-label="spacing" row>
                  {funcionarios.map((element) => (
                    <Card
                      onClick={() => {
                        props.setFuncionarioInfo(element);
                        navigate("/funcionarioID/" + element.id);
                      }}
                      key={element.id}
                      sx={{ margin: 1.5, maxWidth: 180, maxHeight: 340 }}
                    >
                      <br></br>
                      <CardActionArea>
                        <CardMedia
                          component="img"
                          height="180"
                          image={element.imagem}
                          alt="livro"
                        />

                        <CardContent>
                          <Typography gutterBottom variant="h6" component="div">
                            {element.nome}
                          </Typography>
                        </CardContent>
                      </CardActionArea>
                    </Card>
                  ))}
                </RadioGroup>
              </FormControl>
            </Grid>
          </Grid>
        </Paper>
      </Grid>
    </div>
  ) : (
    <Typography variant="h1">empresa não encontrado</Typography>
  );
}
