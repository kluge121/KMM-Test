import SwiftUI
import shared

struct ContentView: View {
    
    @ObservedObject private var viewModel = ViewModel()
    
	let greet = Greeting().greet()

	var body: some View {
        VStack {
            Text(viewModel.text).font(.system(size: 10))
        }
        .padding()
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
