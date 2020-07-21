package main.client.view.receptionistMenu;

import main.client.view.ViewHandler;
import main.client.viewModel.ReceptionistMenuViewModel;

public class ReceptionistMenuController {
    private ViewHandler viewHandler;
    private ReceptionistMenuViewModel vm;

    public void init(ViewHandler viewHandler, ReceptionistMenuViewModel vm) {
        this.viewHandler = viewHandler;
        this.vm = vm;
        vm.loadReceptionist();
    }
}
