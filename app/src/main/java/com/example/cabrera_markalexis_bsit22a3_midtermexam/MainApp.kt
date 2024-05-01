
package com.example.cabrera_markalexis_bsit22a3_midtermexam

// import androidx.annotation.StringRes
// import androidx.compose.foundation.layout.fillMaxHeight
// import androidx.compose.foundation.layout.fillMaxSize
// import androidx.compose.foundation.layout.padding
// import androidx.compose.material.icons.Icons
// import androidx.compose.material.icons.filled.ArrowBack
// import androidx.compose.material3.ExperimentalMaterial3Api
// import androidx.compose.material3.Icon
// import androidx.compose.material3.IconButton
// import androidx.compose.material3.MaterialTheme
// import androidx.compose.material3.Scaffold
// import androidx.compose.material3.Text
// import androidx.compose.material3.TopAppBar
// import androidx.compose.material3.TopAppBarDefaults
// import androidx.compose.runtime.Composable
// import androidx.compose.ui.Modifier
// import androidx.compose.ui.platform.LocalContext
// import androidx.compose.ui.res.dimensionResource
// import androidx.compose.ui.res.stringResource
//
// enum class PokemonQuizScreen(@StringRes val title: Int) {
// Home(title = R.string.title_app_pkmnquizgame),
// About(title = R.string.title_about_pkmnquizgame),
// Game(title = R.string.title_game_pkmnquizgame),
// Exit(title = R.string.title_exit_pkmnquizgame)
// }
//
// @OptIn(ExperimentalMaterial3Api::class)
// @Composable
// fun PokemonAppBar(
// currentScreen: PokemonQuizScreen,
// canNavigateBack: Boolean,
// navigateUp: () -> Unit,
// modifier: Modifier = Modifier
// ){
// TopAppBar(
// title = { Text(stringResource(currentScreen.title)) },
// colors = TopAppBarDefaults.mediumTopAppBarColors(
// containerColor = MaterialTheme.colorScheme.primaryContainer
// ),
// modifier = modifier,
// navigationIcon = {
// if (canNavigateBack) {
// IconButton(onClick = navigateUp) {
// Icon(
// imageVector = Icons.Filled.ArrowBack,
// contentDescription = stringResource(R.string.back_button)
// )
// }
// }
// }
// )
// }
//
// @Composable
// fun PokemonApp(
// viewModel: OrderViewModel = viewModel(),
// navController: NavHostController = rememberNavController()
// ){
// val backStackEntry by navController.currentBackStackEntryAsState()
// val currentScreen = PokemonQuizScreen.valueOf(
// backStackEntry?.destination?.route ?: PokemonQuizScreen.Home.name
// )
//
// Scaffold(
// topBar = {
// PokemonAppBar(
// currentScreen = currentScreen,
// canNavigateBack = navController.previousBackStackEntry != null,
// navigateUp = { navController.navigateUp() }
// )
// }
// ) { innerPadding ->
// val uiState by viewModel.uiState.collectAsState()
//
// NavHost(
// navController = navController,
// startDestination = PokemonQuizScreen.Home.name,
// modifier = Modifier.padding(innerPadding)
// ){
// composable(route = PokemonQuizScreen.Home.name) {
// StartOrderScreen(
// quantityOptions = DataSource.quantityOptions,
// onNextButtonClicked = {
// viewModel.setQuantity(it)
// navController.navigate(PokemonQuizScreen.About.name)
// },
// modifier = Modifier
// .fillMaxSize()
// .padding(dimensionResource(R.dimen.padding_medium))
// )
// }
//
// composable(route = CupcakeScreen.Flavor.name) {
// val context = LocalContext.current
//
// SelectOptionScreen(
// subtotal = uiState.price,
// onNextButtonClicked = {
// navController.navigate(CupcakeScreen.Pickup.name)
// },
// onCancelButtonClicked = {
// cancelOrderAndNavigateToStart(viewModel, navController)
// },
// options = DataSource.flavors.map { id -> context.resources.getString(id) },
// onSelectionChanged = { viewModel.setFlavor(it) },
// modifier = Modifier.fillMaxHeight()
// )
// }
//
// composable(route = CupcakeScreen.Pickup.name) {
//
// SelectOptionScreen(
// subtotal = uiState.price,
// onNextButtonClicked = {
// navController.navigate(CupcakeScreen.Summary.name)
// },
// onCancelButtonClicked = {
// cancelOrderAndNavigateToStart(viewModel, navController)
// },
// options = uiState.pickupOptions,
// onSelectionChanged = { viewModel.setDate(it) },
// modifier = Modifier.fillMaxHeight()
// )
// }
//
// composable(route = CupcakeScreen.Summary.name) {
// val context = LocalContext.current
// OrderSummaryScreen(
// orderUiState = uiState,
// onCancelButtonClicked = {
// cancelOrderAndNavigateToStart(viewModel, navController)
// },
// onSendButtonClicked = { subject: String, summary: String ->
// shareOrder(context, subject = subject, summary = summary)
// },
// modifier = Modifier.fillMaxHeight()
// )
// }
// }
// }
// }