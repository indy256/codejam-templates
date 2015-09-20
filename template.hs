import Data.List
import Text.Printf

main :: IO ()
main = interact $
  unlines . zipWith output [1..] . map (solve.words) . tail . lines

output :: Int -> Double -> String
output testCase res = "Case #" ++ show testCase ++ ": " ++ printf "%.10f" res

solve :: [String] -> Double
solve (cmd: x)
  | cmd == "mean" = (foldl (+) 0 a) / (fromIntegral $ ((length x) - 1))
  | cmd == "median" = sort a !! (quot ((length x) - 1) 2)
  where a = map read $ tail x
