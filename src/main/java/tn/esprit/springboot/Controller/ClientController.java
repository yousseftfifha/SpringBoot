package tn.esprit.springboot.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springboot.Entities.Client;
import tn.esprit.springboot.Interfaces.ClientService;

import java.util.List;

@RestController
@Api(tags = "Client management")
@RequestMapping("/client")
public class ClientController {

     @Autowired
     ClientService clientService;

    @ApiOperation(value = "Retrieving all clients")
    @GetMapping("/retrieve-all-clients")
    @ResponseBody
    public List<Client> getClients() {
        return clientService.retrieveAllClients();
    }

    @ApiOperation(value = "Retrieving one clients")
    @GetMapping("/retrieve-client/{client-id}")
    @ResponseBody
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.retrieveClient(clientId);
    }

    @ApiOperation(value = "Add a client")
    @PostMapping("/add-client")
    @ResponseBody
    public Client addClient(@RequestBody Client c)
    {
        return clientService.addClient(c);
    }

    @ApiOperation(value = "Remove a client")
    @DeleteMapping("/remove-client/{client-id}")
    @ResponseBody
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.deleteClient(clientId);
    }

    @ApiOperation(value = "Updating  a clients")
    @PutMapping("/modify-client")
    @ResponseBody
    public Client modifyClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }
}
