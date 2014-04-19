package fr.tingo.istudent.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Sauvegarde {
	
	public static final String DEFAULT_DEVOIRS = ""; // Le texte par defaut des devoirs

	
	
	
	/** Charge la liste des matieres de l'�l�ve */
	public static List<Matiere> loadListMatiere(String id, Context context)
	{
		List<Matiere> list = new ArrayList<Matiere>();
		
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		
		int maxStr = preferences.getInt("size_" + id, 0);

		for(int i = 0; i < maxStr; i++)
		{
			list.add(Sauvegarde.loadMatiere(id, context));
		}

		return list;
	}
	
	/** Enregistres une String dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static void saveListMatiere(String id, List<Matiere> list, Context c)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		
		int size = list.size();
		editor.putInt("size_" + id, size);
		
		for(int i = 0; i < size; i++)
		{
			Sauvegarde.saveMatiere(list.get(i), id + i, c);
		}
		
		editor.commit();
	}
	
	/** Ajoutes une string � la liste sauvegard� */
	public static void addMatiereToList(String id, Matiere mat, Activity activity)
	{
		List<Matiere> list = Sauvegarde.loadListMatiere(id, activity);
		list.add(mat);
		Sauvegarde.saveListMatiere(id, list, activity);
	}
	
	
	/** Supprimes une Matiere de la liste */
	public static void removeMatiereFromList(String id, Matiere matiereRemoved, Activity activity)
	{
		List<Matiere> list = Sauvegarde.loadListMatiere(id, activity);
		list.remove(matiereRemoved);
		Sauvegarde.saveListMatiere(id, list, activity);
	}
	
	
	
	
	
	
	
	
	
	
	/** Recupere une matiere */
	public static Matiere loadMatiere(String id, Context context)
	{
		SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		p = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences		
		
		Matiere matiere = new Matiere(p.getString(id, ""), p.getFloat(id, 0));
		matiere.notes = Sauvegarde.loadListFloat(id, context);
		
		return new Matiere(p.getString(id, ""), p.getFloat(id, 0));
	}
	
	
	/** Sauvegarde une matiere */
	public static void saveMatiere(Matiere matiere, String id, Context context)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		
		editor.putFloat(id, matiere.coef);
		editor.putString(id, matiere.matiere);
		
		Sauvegarde.saveListFloat(id, matiere.notes, context);
		
		editor.commit();
	}
	
	
	
	
	

	
	/** Recuperes une List de tableau de Float enregistr� dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static List<Float[]> loadListFloat(String id, Context context)
	{
		List<Float[]> list = new ArrayList<Float[]>();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		
		Float[] floate = new Float[2];
		int maxStr = preferences.getInt("f1_" + id, 0);

		for(int i = 0; i < maxStr; i++)
		{
			floate[0] = preferences.getFloat(id + i + "1", 0);
			floate[0] = preferences.getFloat(id + i + "2", 0);
			list.add(floate);
		}

		return list;
	}
	
	
	/** Enregistres une List de tableau de Float dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static void saveListFloat(String id, List<Float[]> list, Context c)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		

		int size = list.size();
		editor.putInt("f1_" + id, size);
	
		for(int i = 0; i < size; i++)
		{
			editor.putFloat(id + i + "1", list.get(i)[0]);
			editor.putFloat(id + i + "2", list.get(i)[1]);
		}
		
		editor.commit();
	}
	
	
	/** Ajoutes une string � la liste sauvegard� */
	public static void addFloatsToList(String id, Float[] floate, Activity activity)
	{
		List<Float[]> list = Sauvegarde.loadListFloat(id, activity);
		list.add(floate);
		Sauvegarde.saveListFloat(id, list, activity);
	}
	
	
	/** Ajoutes un Float � la liste sauvegard� */
	public static void removeFloatFromList(String id, Float[] floatRemoved, Activity activity)
	{
		List<Float[]> list = Sauvegarde.loadListFloat(id, activity);
		list.remove(floatRemoved);
		Sauvegarde.saveListFloat(id, list, activity);
	}

	
	
	
	
	
	
	/** Recuperes une String enregistr� dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static List<String> loadListString(String id, Context context)
	{
		List<String> list = new ArrayList<String>();
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(context); // On recupere les SharedPreferences
		
		int maxStr = preferences.getInt("int_" + id, 0);

		for(int i = 0; i < maxStr; i++)
		{
			list.add(preferences.getString(id + i, ""));
		}

		return list;
	}
	
	/** Enregistres une String dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static void saveListString(String id, List<String> list, Context c)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		
		int size = list.size();
		editor.putInt("int_" + id, size);
		
		for(int i = 0; i < size; i++)
		{
			editor.putString(id + i, list.get(i));
		}
		
		editor.commit();
	}
	
	/** Ajoutes une string � la liste sauvegard� */
	public static void addStringToList(String id, String str, Activity activity)
	{
		List<String> list = Sauvegarde.loadListString(id, activity);
		list.add(str);
		Sauvegarde.saveListString(id, list, activity);
	}
	
	
	/** Supprime une string � la liste sauvegard� */
	public static void removeStringFromList(String id, String strRemoved, Activity activity)
	{
		List<String> list = Sauvegarde.loadListString(id, activity);
		list.remove(strRemoved);
		Sauvegarde.saveListString(id, list, activity);
	}
	
	
	
	

	
	
	/** Enregistres une String dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static void saveString(String id, String stringSaved, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		editor.putString(id, stringSaved);
		editor.commit();	
	}
	
	
	/** Recuperes une String enregistr� dans les SharedPreferences (m�moire morte du t�l�phone)
	 *  Args: ID de la String, String en cas d'erreur de chargement (not found), activity actuelle
	 **/
	public static String loadString(String id, String errorString, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		return preferences.getString(id, errorString);
	}

	
	
	
	
	/** Enregistres une Integer dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static void saveInt(String id, int intSaved, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		editor.putInt(id, intSaved);
		editor.commit();	
	}
	
	
	/** Recuperes une Integer enregistr� dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static int loadInt(String id, int errorInt, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		return preferences.getInt(id, errorInt);
	}
	
	
	
	
	
	/** Enregistres un Float dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static void saveFloat(String id, float floatSaved, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		SharedPreferences.Editor editor = preferences.edit(); // On recupere l'edit des SharedPreferences
		editor.putFloat(id, floatSaved);
		editor.commit();	
	}
	
	
	/** Recuperes un Float enregistr� dans les SharedPreferences (m�moire morte du t�l�phone) */
	public static float loadFloat(String id, float errorFloat, Activity activity)
	{
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		preferences = PreferenceManager.getDefaultSharedPreferences(activity); // On recupere les SharedPreferences
		return preferences.getFloat(id, errorFloat);
	}
	
	
	
	

}
