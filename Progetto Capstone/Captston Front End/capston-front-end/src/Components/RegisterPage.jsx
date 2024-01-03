import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useEffect, useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
const RegisterPage = () => {
  const [nome, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [email, setEmail] = useState("");
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [refresh, setRefresh] = useState(false);
  const [numeroDiTelefono, setNumeroDiTelefono] = useState("");
  const baseEndpoint = "http://localhost:8080/api/auth/register";

  const postRegisterUser = async () => {
    let response = await fetch(baseEndpoint, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        nome: nome,
        cognome: surname,
        email: email,
        username: username,
        password: password,
        cliente: {
          nome: nome,
          cognome: surname,
          email: email,
          username: username,
          telefono: numeroDiTelefono,
        },
      }),
    });
    const res = await response.json();
    console.log(res);
  };
  useEffect(() => {}, [refresh]);

  return (
    <>
      <Container fluid className="pageContent mainContent">
        <Row id="registrationPage" className="m-0 pb-3">
          <Container>
            <Container className="p-0 my-3 mb-5 rounded">
              <Container>
                <Form>
                  <Form.Group className="mb-3">
                    <Form.Label>Nome</Form.Label>
                    <Form.Control
                      onChange={(e) => setName(e.target.value)}
                      value={nome}
                      type="input"
                      className="mb-4"
                      placeholder="Inserisci il tuo nome"
                    />
                    <Form.Label>Cognome</Form.Label>
                    <Form.Control
                      onChange={(e) => setSurname(e.target.value)}
                      value={surname}
                      type="input"
                      className="mb-4"
                      placeholder="Inserisci il tuo cognome"
                    />
                    <Form.Label>Username</Form.Label>
                    <Form.Control
                      onChange={(e) => setUsername(e.target.value)}
                      value={username}
                      type="input"
                      className="mb-4"
                      placeholder="Inserisci il tuo username"
                    />
                    <Form.Label>Numero di telefono</Form.Label>
                    <Form.Control
                      onChange={(e) => setNumeroDiTelefono(e.target.value)}
                      value={numeroDiTelefono}
                      type="number"
                      className="mb-4"
                      placeholder="Inserisci il tuo numero di telefono"
                    />
                    <Form.Label>Email address</Form.Label>
                    <Form.Control
                      onChange={(e) => setEmail(e.target.value)}
                      value={email}
                      type="input"
                      className="mb-4"
                      placeholder="Inserisci la tua email"
                    />
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                      onChange={(e) => setPassword(e.target.value)}
                      value={password}
                      type="input"
                      className="mb-4"
                      placeholder="Inserisci la tua password"
                    />
                    <Form.Text className="text-muted">
                      We'll never share your password with anyone else.
                    </Form.Text>
                  </Form.Group>
                  <Row>
                    <Col>
                      <Button
                        onClick={(e) => {
                          e.preventDefault();
                          if (
                            nome === "" ||
                            surname === "" ||
                            email === "" ||
                            username === "" ||
                            password === "" ||
                            numeroDiTelefono === ""
                          ) {
                            alert("Per favore compila tutti i campi");
                          } else {
                            postRegisterUser();
                            setRefresh(!refresh);
                          }
                        }}
                        type="submit"
                      >
                        Submit
                      </Button>
                    </Col>
                    <Col>
                      <p>
                        Già registrato? Logga!{"   "}
                        <Button href="/login">Login</Button>
                      </p>
                    </Col>
                  </Row>
                </Form>
              </Container>
            </Container>
          </Container>
        </Row>
      </Container>
    </>
  );
};

export default RegisterPage;
