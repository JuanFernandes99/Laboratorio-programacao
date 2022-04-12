import { Typography } from "@mui/material";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Card from "@mui/material/Card";
import CardMedia from "@mui/material/CardMedia";
import Grid from "@mui/material/Grid";
import { CardActionArea } from "@mui/material";
import "./funcionarioSelecionado.css";
export function FuncionarioSelecionado(props) {
  const API_URL = "http://localhost:8080";
  const [salarios, setListaSalarios] = useState([]);
  const params = useParams();
  useEffect(() => {
    getSalarios();
    if (!params.id) {
      alert("nao tem Empresa ");
      return;
    }
  }, []);

  function getSalarios() {
    fetch(API_URL + "/getSalariosByPessoa/" + props.funcionarioInfo.id, {
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
        setListaSalarios(parsedResponse);
        console.log(parsedResponse);
      })
      .catch((error) => {
        alert(error);
      });
  }
  return props.funcionarioInfo !== {} ? (
    <div>
      <Grid sx={{ flexGrow: 1, marginTop: 5 }} container spacing={2}>
        <Grid container>
          <Grid container justifyContent="center">
            <Card sx={{ maxWidth: 400, margin: 1 }}>
              <CardMedia
                component="img"
                height="250"
                image={props.funcionarioInfo.imagem}
                alt="clienteIMG"
              />
              <br></br>
              <p> Informações gerais</p>
              <p>{"Nome: " + props.funcionarioInfo.nome}</p>
              <p>{"morada: " + props.funcionarioInfo.morada}</p>
              <p>{"idade: " + props.funcionarioInfo.idade}</p>
              <p>{"email: " + props.funcionarioInfo.email}</p>
            </Card>

            <Card sx={{ width: 600, margin: 1 }}>
              <CardActionArea>
                <CardMedia />
              </CardActionArea>
              <p id="textoSobre"> - Salarios -</p>
              <table>
                <tbody>
                  <tr>
                    <th>Data</th>
                    <th>quantidade</th>
                  </tr>

                  {salarios.map((element) => (
                    <tr key={element.id}>
                      <td>{element.data}</td>
                      <td>{element.quantidade}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </Card>
          </Grid>
        </Grid>
      </Grid>
    </div>
  ) : (
    <Typography variant="h1">funcionario não encontrado</Typography>
  );
}
